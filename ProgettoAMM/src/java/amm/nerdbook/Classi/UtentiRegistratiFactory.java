/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;
import java.util.ArrayList; 
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
        utente1.setNickname("Lau23");
        utente1.setNome("Laura");
        utente1.setCognome("Argiolu");
        utente1.setImgProfilo("img/Foto1.jpg");
        utente1.setDataNasc("23/08/1995");
        utente1.setPassw("123");
        
        //Aurora Russo
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente1.setId(1);
        utente1.setNickname("Aury92");
        utente1.setNome("Aurora");
        utente1.setCognome("Russo");
        utente1.setImgProfilo("img/Foto2.jpg");
        utente1.setDataNasc("03/08/1992");
        utente1.setPassw("1011");
        
        //Federico Brundu
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente1.setId(2);
        utente1.setNickname("Fede89");
        utente1.setNome("Federico");
        utente1.setCognome("Brundu");
        utente1.setImgProfilo("img/Foto3.jpg");
        utente1.setDataNasc("01/07/1989");
        utente1.setPassw("0000");

        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        
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
                if(utente.getNome().equals(user) && utente.getPassw().equals(password)){
                    return utente.getId();
                }
            }
            return -1;
        }
        
}

    