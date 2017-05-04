/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author Argio
 */
public class UtentiRegistrati {
    
    private int id;
    private String nickname;
    private String nome;
    private String cognome;
    private String imgProfilo;
    private String frasePres;
    private String dataNasc;
    private String passw;

    
    public UtentiRegistrati(){
        id = 0;
        nickname = "";
        nome = "";
        cognome = "";
        imgProfilo = "";
        frasePres = "";
        dataNasc = "";
        passw = "";
        
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;                
    }
    
    public String getNickname(){
        return nickname;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;                
    }

    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;                
    }
    
    public String getCognome(){
        return cognome;
    }
    
    public void setCognome(String cognome){
        this.cognome = cognome;                
    }
    
    public String getImgProfilo(){
        return imgProfilo;
    }
    
    public void setImgProfilo(String imgProfilo){
        this.imgProfilo = imgProfilo;
                
    }
        
    public String getFrasePres(){
        return frasePres;
    }
    
    public void setFrsasePres(String frasePres){
        this.frasePres = frasePres;
                
    }

    public String getDataNasc(){
        return dataNasc;
    }
    
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
                
    }
    
    public String getPassw(){
        return passw;
    }
    
    public void setPassw(String passw){
        this.passw = passw;
                
    }
 
    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof UtentiRegistrati)
            if (this.getId() == ((UtentiRegistrati)altroUtente).getId()) return true;
        return false;
    }

}
    
    

