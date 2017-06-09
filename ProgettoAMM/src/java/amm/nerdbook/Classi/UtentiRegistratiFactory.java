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

    private UtentiRegistratiFactory() {
     /*   //Creazione utenti

        //Laura Argiolu
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.Username("Lau23");
        utente1.setNome("Laura");
        utente1.setCognome("Argiolu");
        utente1.setImgProfilo("img/Foto1.jpg");
        utente1.setFrsasePres("Non mi scoraggio perché ogni tentativo sbagliato scartato è un altro passo avanti.");
        utente1.setDataNasc("23/08/1995");
        utente1.setPassword("123");
        
        
        //Aurora Russo
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(1);
        utente2.Username("Aury92");
        utente2.setNome("Aurora");
        utente2.setCognome("Russo");
        utente2.setImgProfilo("img/Foto2.jpg");
        utente2.setFrsasePres("Il futuro appartiene a coloro che credono nella bellezza dei propri sogni");
        utente2.setDataNasc("03/08/1992");
        utente2.setPassword("1011");
        
        //Federico Brundu
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(2);
        utente3.Username("Fede89");
        utente3.setNome("Federico");
        utente3.setCognome("Brundu");
        utente3.setImgProfilo("img/Foto3.jpg");
        utente3.setFrsasePres("Il segreto per andare avanti è iniziare");
        utente3.setDataNasc("01/07/1989");
        utente3.setPassword("0000");
        
        //Utente incompleto
        UtentiRegistrati utente4 = new UtentiRegistrati();
        utente4.setId(3);
        utente4.Username("incomp23");
        utente4.setNome("ADALGISO");
        utente4.setCognome("");
        utente4.setImgProfilo("");
        utente4.setFrsasePres("");
        utente4.setDataNasc("01/02/1992");
        utente4.setPassword("0000");
     
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);*/
    }

    public UtentiRegistrati getUtenteById(int id) {
       /* for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;*/
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "select * from utenti "
                    + "where utenti_id = ?";
            
            // Prepared Statement
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
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = 
                      "select * from utenti";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
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
        /*for(UtentiRegistrati utente : this.listaUtenti){
            if(utente.getUsername().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;*/
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Lauretta23", "1234");
            
            String query = "select utenti_id from utenti "
                    + "where username = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
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
            
            String query = "select utenti_id, nome, cognome, imgprofilo from utenti where nome like '"+ stringa +"'";

            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
                        
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                UtentiRegistrati current = new UtentiRegistrati();
                current.setId(res.getInt("utenti_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }

        
}

    