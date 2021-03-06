/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Post;
import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.UtentiRegistrati;
import amm.nerdbook.Classi.UtentiRegistratiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Argio
 */
public class Bacheca extends HttpServlet {

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
        
        // sessione e riprende
        HttpSession session = request.getSession(false);     
        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            return;
        }
        
        int id = (int)session.getAttribute("loggedUserID");
        if(request.getParameter("user") != null){
            id = Integer.parseInt(request.getParameter("user"));
        }
        
        UtentiRegistrati utente = UtentiRegistratiFactory.getInstance().getUtenteById(id);
        if(utente == null){

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        //prendo valore idUtenteLoggato in sessione
        
        PostFactory postF = PostFactory.getInstance();
        List<Post> postsUtente = postF.getPostList(utente);
        request.setAttribute("posts", postsUtente);
        request.setAttribute("utenti", UtentiRegistratiFactory.getInstance().GetAll());
        request.setAttribute("utente",utente );
        request.getRequestDispatcher("bacheca.jsp").forward(request, response);

        /*UtentiRegistrati utente = UtentiRegistratiFactory.getInstance().getUtenteById(id);
        ArrayList<Post> postsUtente = new ArrayList<>();
                postUtente = PostFactory.getInstance().getPostList(utente);
        request.setAttribute("posts", postsUtente);        
        request.setAttribute("utente",utente );*/
        
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
