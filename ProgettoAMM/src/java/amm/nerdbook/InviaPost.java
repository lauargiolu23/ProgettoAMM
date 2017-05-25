/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import amm.nerdbook.Classi.Post;
import amm.nerdbook.Classi.UtentiRegistratiFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Argio
 */
public class InviaPost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        UtentiRegistratiFactory utenteFactory = UtentiRegistratiFactory.getInstance();
        
        Post post1 = new Post();
        post1.setContent("Solo il nostro gusto individuale, alla fine, riesce davvero a creare uno stile o una moda,"
                + " poiché non si preoccupa di seguire la scia degli altri. Perciò, indipendentemente dall’oggetto che il gusto individuale"
                + " ci fa scegliere, sia esso una scala a pioli oppure una cesta di vimini, alla base ci deve essere una scelta profondamente personale");
        post1.setId(0);
        post1.setUser(utenteFactory.getUtenteById(13));
        post1.setPostType(Post.Type.TEXT);
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(utenteFactory.getConnectionString(), "Lauretta23", "1234");
            
            String query = "INSERT INTO post (post_id, content, type, author, testo)"
                    + "VALUES (default, 'https://it-it.facebook.com/', 3, 13, 'La sincerità è l eventuale inganno di tutti i grandi uomini.')";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
                       
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}