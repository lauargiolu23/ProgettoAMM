/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.GruppiFactory;
import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.UtentiRegistratiFactory;
        
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.nerdbook.Classi.UtentiRegistrati;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;



/**
 *
 * @author Argio
 * 
 * 
 */
@WebServlet (loadOnStartup = 0)

public class Login extends HttpServlet {
        private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

        private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";

        private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
        
        @Override

   public void init(){

       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;

       try {

           Class.forName(JDBC_DRIVER);

       } catch (ClassNotFoundException ex) {

           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

       }

       UtentiRegistratiFactory.getInstance().setConnectionString(dbConnection);
       PostFactory.getInstance().setConnectionString(dbConnection);
       GruppiFactory.getInstance().setConnectionString(dbConnection);

   }

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
       

        //Apertura della sessione e riprende
        HttpSession session = request.getSession();
        
        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) 
        {

            request.getRequestDispatcher("Bacheca").forward(request, response);
            return;
        
        //Se l'utente non è loggato mi manda nella pag login.jsp
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        
            if (username != null && password != null) 
            {   ///controlla utente logged
                int loggedUserID = UtentiRegistratiFactory.getInstance().getIdByUserAndPassword(username, password);
                
                //se l'utente è valido...
                if(loggedUserID != -1)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    //ci devo aggiungere qualcuno
                    UtentiRegistrati utente = UtentiRegistratiFactory.getInstance().getUtenteById(loggedUserID);
                    if(utente.getNome().equals("") ||
                        utente.getCognome().equals("") ||
                        utente.getImgProfilo().equals("") ||
                        utente.getFrasePres().equals(""))
                    {
                        request.getRequestDispatcher("Profilo").forward(request, response);
                        return;
                    }else{
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                        return;
                    }
                } 
                else { //altrimenti se la coppia user/pass non è valida (id==-1)
                    
                //ritorno al form del login informandolo che i dati non sono validi
                request.setAttribute("invalidData", true);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
                }
            }  
        }    
    
        /*
          Se non si verifica nessuno degli altri casi, 
          tentativo di accesso diretto alla servlet Login -> reindirizzo verso 
          il form di login.
        */
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
