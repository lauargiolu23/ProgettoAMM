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
public class Gruppi {
    private int id;
    private String nome;
    private List<UtentiRegistrati> iscritti = new ArrayList<UtentiRegistrati>();

    public Gruppi(){
       id= 0;
       nome = "";
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    
    public List<UtentiRegistrati> getIscritti() {
        return iscritti;
    }

    public void iscriviti(UtentiRegistrati utente) {
        this.iscritti.add(utente);
    }
    
    public ArrayList getUtenteById(){
        
        ArrayList<UtentiRegistrati> listaU = new ArrayList<UtentiRegistrati>();
        for(UtentiRegistrati item : this.iscritti){
            listaU.add(item);
        }
        return listaU;
    }
    
    
    
}

