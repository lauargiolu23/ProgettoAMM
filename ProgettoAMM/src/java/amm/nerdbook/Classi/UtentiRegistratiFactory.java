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
import java.util.HashSet;
import java.util.*;
import java.util.Set;
import amm.nerdbook.Classi.UtentiRegistrati;
/**
 *
 * @author Argio
 */
public class UtentiRegistratiFactory {
    //gestione dei Database
    private String connectionString;
        
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    }
    
    private static UtentiRegistratiFactory singleton;

    public static UtentiRegistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiRegistratiFactory();
        }
        return singleton;
    }
    
    private ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();

    private UtentiRegistratiFactory(){} 
    
    public UtentiRegistrati getUtenteById(int id) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "select * from utenti "
                    + "where utenti_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                UtentiRegistrati current = new UtentiRegistrati();
                current.setId(res.getInt("utenti_id"));
                current.setUsername(res.getString("username"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setFrsasePres(res.getString("frasePres"));
                current.setImgProfilo(res.getString("imgProfilo"));
                current.setDataNasc(res.getString("datadinascita"));      
                current.setPassword(res.getString("password"));

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
     public List<UtentiRegistrati> GetAll() {
        
        List<UtentiRegistrati> result = new ArrayList<UtentiRegistrati>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "select * from utenti";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                UtentiRegistrati current = new UtentiRegistrati();
                current.setId(res.getInt("utenti_id"));
                current.setUsername(res.getString("username"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setFrsasePres(res.getString("frasePres"));
                current.setImgProfilo(res.getString("imgProfilo"));
                current.setDataNasc(res.getString("datadinascita"));      
                current.setPassword(res.getString("password"));

                result.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return result;
    }
    public int getIdByUserAndPassword(String user, String password){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = "select utenti_id from utenti "
                    + "where username = ? and password = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("utenti_id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public List<UtentiRegistrati> getsearchList(String stringa){
            
        List<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();
    
        try{    
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            /*
            String query = "select utenti_id, nome, cognome, imgprofilo from utenti where nome like '"+ stringa +"'";
*/
            String query = 
                      "select * from utenti where name like ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, "%" + stringa + "%");
                        
            ResultSet res = stmt.executeQuery();
            
            while (res.next()) {
                UtentiRegistrati current = new UtentiRegistrati();
                current.setId(res.getInt("utenti_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setImgProfilo(res.getString("urlFotoProfilo"));
                current.setFrsasePres(res.getString("fraseDiPresentazione"));
                current.setDataNasc(res.getString("dataNascita"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }

    /**/
    /*
    public void modificaDati(Utente utente){
        try {

            Connection conn = DriverManager.getConnection(connectionString, "marko123", "asdasd");
            
            String query = 
                      "update utenti (utente_id, username, nome, cognome, password, urlfotoprofilo, frasedipresentazione, datanascita) "
                    + "values (?, ? , ? , ? , ?, ?, ? , ?)";
            

            PreparedStatement stmt = conn.prepareStatement(query);
            

            stmt.setInt(1, utente.getId());

            stmt.setString(2, utente.getUsername());
            
            stmt.setString(3, utente.getNome());
            
            stmt.setString(4, utente.getCognome());
            
            stmt.setString(5, utente.getPassword());
            
            stmt.setString(6, utente.getUrlFotoProfilo());
            
            stmt.setString(7, utente.getFraseDiPresentazione());
            
            stmt.setString(8, utente.getDataNascita());

            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    */
       
}

    