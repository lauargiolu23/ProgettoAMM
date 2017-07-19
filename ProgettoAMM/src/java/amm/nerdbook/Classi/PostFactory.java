/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Argio
 */
public class PostFactory {
    
    private String connectionString;
        
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    }
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

  private PostFactory() {}

    public Post getPostById(int id) {
        UtentiRegistratiFactory utentiFactory = UtentiRegistratiFactory.getInstance();
        
          try {
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "select * from post "
                    + "join posttype on post.type = posttype.posttype_id "
                    + "where post_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                //imposto l'autore del post
                UtentiRegistrati autore = utentiFactory.getUtenteById(res.getInt("author"));
                current.setUser(autore);

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List getPostList(UtentiRegistrati user) {

//        List<Post> listaPost = new ArrayList<Post>();
//
//        for (Post post : this.listaPost) {
//            UtentiRegistrati utente = post.getUser();
//            if (utente.equals(user)) {
//                listaPost.add(post);
//            }
//        }
//        return listaPost;
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = "select * from post "
                    + "join posttype on post.type = posttype.posttype_id "
                    + "where author = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, user.getId());
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                //imposto l'autore del post
                current.setUser(user);
                //imposto testo del post
                current.setTesto(res.getString("testo"));
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    //questo non c'è è da vedere!!!!!!!!!!!!!!
    public List getPostList(Gruppi gr) {
        //prendo un gruppo
        //in ogni gruppo ci sono iscritti
        //ho deciso che se clicki su gruppo vedi i post degli utenti inscritti a quel gruppo
        //cicli gli utenti del gruppo e guardi se il post è stato scritto da uno del gruppo
        List<Post> listaPost = new ArrayList<Post>();
        for(UtentiRegistrati item : gr.getIscritti()){
            for (Post post : this.listaPost) {
                if (post.getId() == (item.getId())) {
                    listaPost.add(post);
                }
            }
        }
        return listaPost;
    }
    private Post.Type postTypeFromString(String type){
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        if(type.equals("URL"))
            return Post.Type.URL;
        return Post.Type.TEXT;
    }
    
 
    private int postTypeFromEnum(Post.Type type){
        if(type == Post.Type.TEXT)
                return 1;
            else
                if(type == Post.Type.IMAGE)
                    return 2;
        return 3;
    }

    
    public void addNewPost(Post post){
        try {

            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "insert into post (post_id, content, type, author, testo) "
                    + "values (default, ? , ? , ? , ?)";
            

            PreparedStatement stmt = conn.prepareStatement(query);
            

            stmt.setString(1, post.getContent());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            stmt.setString(4, post.getTesto());
            

            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
   
    
}
