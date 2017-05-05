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
    private String nome;
    private List<UtentiRegistrati> iscritti = new ArrayList<UtentiRegistrati>();

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

    public List<UtentiRegistrati> getIscritti() {
        return iscritti;
    }

    public void iscriviti(UtentiRegistrati utente) {
        this.iscritti.add(utente);
    }
    
    public UtentiRegistrati getUtenteById(int id){
        for(UtentiRegistrati item : this.iscritti){
            if(item.getId() == id)
                return item;
        }
        return null;
    }
    
    
    
}

