/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Argio
 */
public class PostFactory {
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

  private PostFactory() {
        
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
        listaPost.add(post3);
        
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtentiRegistrati user) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(user)) {
                listaPost.add(post);
            }
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
}
