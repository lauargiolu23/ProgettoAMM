/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;
import java.util.ArrayList; 
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Argio
 */
public class UtentiRegistratiFactory {
    
    private static UtentiRegistratiFactory singleton;

    public static UtentiRegistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiRegistratiFactory();
        }
        return singleton;
    }
    
    private ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();

    private UtentiRegistratiFactory() {
        //Creazione utenti

        //Laura Argiolu
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.Username("Lau23");
        utente1.setNome("Laura");
        utente1.setCognome("Argiolu");
        utente1.setImgProfilo("img/Foto1.jpg");
        utente1.setFrsasePres("Il gatto è morto");
        utente1.setDataNasc("23/08/1995");
        utente1.setPassword("123");
        
        
        //Aurora Russo
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(1);
        utente2.Username("Aury92");
        utente2.setNome("Aurora");
        utente2.setCognome("Russo");
        utente2.setImgProfilo("img/Foto2.jpg");
        utente2.setFrsasePres("Il gatto è vivo");
        utente2.setDataNasc("03/08/1992");
        utente2.setPassword("1011");
        
        //Federico Brundu
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(2);
        utente3.Username("Fede89");
        utente3.setNome("Federico");
        utente3.setCognome("Brundu");
        utente3.setImgProfilo("img/Foto3.jpg");
        utente3.setFrsasePres("Il gatto è brutto");
        utente3.setDataNasc("01/07/1989");
        utente3.setPassword("0000");
        
        //Utente incompleto
        UtentiRegistrati utente4 = new UtentiRegistrati();
        utente4.setId(3);
        utente4.Username("incomp23");
        utente4.setNome("Inco");
        utente4.setCognome("Rinco");
        utente4.setImgProfilo("www.Rincoinco.pino");
        utente4.setFrsasePres("");
        utente4.setDataNasc("01/02/2099");
        utente4.setPassword("0000");
     
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
    }

    public UtentiRegistrati getUtenteById(int id) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(UtentiRegistrati utente : this.listaUtenti){
            if(utente.getUsername().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
        
}

    