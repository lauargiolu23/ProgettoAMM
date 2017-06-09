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

  private PostFactory() {/*
        
        UtentiRegistratiFactory utenteFactory = UtentiRegistratiFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Solo il nostro gusto individuale, alla fine, riesce davvero a creare uno stile o una moda,"
                + " poiché non si preoccupa di seguire la scia degli altri. Perciò, indipendentemente dall’oggetto che il gusto individuale"
                + " ci fa scegliere, sia esso una scala a pioli oppure una cesta di vimini, alla base ci deve essere una scelta profondamente personale");
        post1.setId(0);
        post1.setUser(utenteFactory.getUtenteById(0));
        post1.setPostType(Post.Type.TEXT);

        Post post2 = new Post();
        post2.setContent("img/Foto4.jpg");
        post2.setId(1);
        post2.setUser(utenteFactory.getUtenteById(0));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContent("https://it-it.facebook.com/");
        post3.setId(2);
        post3.setUser(utenteFactory.getUtenteById(1));
        post3.setPostType(Post.Type.URL);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);*/
        
    }

    public Post getPostById(int id) {/*
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;*/
        UtentiRegistratiFactory utentiFactory = UtentiRegistratiFactory.getInstance();
        
          try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "select * from post "
                    + "join posttype on post.type = posttype.posttype_id "
                    + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
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
    
    
    
    /*ERRORE:
    Nonostante i continui tentativi non sono riuscita a farmi restituire la lista dei post.
    
    se fosse possibile vorrei spiegarmi la motivazione.
    
    Gazie!
     
    */
    

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
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
//            String query = "select content from post "
//                    + "join posttype on post.type = posttype.posttype_id "
//                    + "where author = ?";
            
            String query = "select * from post join postType on type = posttype_id where author = ?";


            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                current.setTesto(res.getString("testo"));

                //imposto l'autore del post
                current.setUser(user);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
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
    
}
