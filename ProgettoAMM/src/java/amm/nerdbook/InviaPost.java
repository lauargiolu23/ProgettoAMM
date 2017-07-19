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
import amm.nerdbook.Classi.Post.Type;
import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.UtentiRegistrati;
import amm.nerdbook.Classi.UtentiRegistratiFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import javax.servlet.http.HttpSession;

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
        
        HttpSession session = request.getSession(false);
        
        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
            if(request.getParameter("thereIsPost")!=null)
            {
                String thereIsPost = request.getParameter("thereIsPost");
                String content = request.getParameter("textPost");
                String type = request.getParameter("postType");
                String text = request.getParameter("testoType");
                if(thereIsPost.equals("needConfirm")){
                    request.setAttribute("content", content);
                    request.setAttribute("text", text);
                    request.setAttribute("typePost", type);
                    request.setAttribute("newpost", "true");
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    return;
                }
                else{
                   
                    Post post = new Post();
                    post.setContent(content);
                    if(type.equals("textType"))
                        post.setPostType(Post.Type.TEXT);
                    if(type.equals("imgType"))
                        post.setPostType(Post.Type.IMAGE);
                    else
                        post.setPostType(Post.Type.URL);
                   post.setTesto(text);
                    
                    post.setUser(UtentiRegistratiFactory.getInstance().getUtenteById((Integer)session.getAttribute("loggedUserID")));
                    PostFactory.getInstance().addNewPost(post);
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("nuovopost.jsp").forward(request, response);
                return;
            }
        }
        else{
            request.getRequestDispatcher("Login").forward(request, response);
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
