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
public class GruppiFactory {
    
    private String connectionString;
        
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    }
    
    private static GruppiFactory singleton;

    public static GruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppiFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();
       
    private GruppiFactory() {/*
        
        UtentiRegistratiFactory utenteFactory = UtentiRegistratiFactory.getInstance();

        //Creazione Gruppi
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setNome("Gli esploratori");
        gruppo1.iscriviti(utenteFactory.getUtenteById(0));
        gruppo1.iscriviti(utenteFactory.getUtenteById(1));    
        gruppo1.iscriviti(utenteFactory.getUtenteById(2)); 
        
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setNome("Gli Equilibristi");
        gruppo2.iscriviti(utenteFactory.getUtenteById(1));
        gruppo2.iscriviti(utenteFactory.getUtenteById(2));  
        
        Gruppi gruppo3 = new Gruppi();
        gruppo3.setNome("I Paracadutisti");
        gruppo3.iscriviti(utenteFactory.getUtenteById(0));
        gruppo3.iscriviti(utenteFactory.getUtenteById(2)); 
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);*/
    }
}
