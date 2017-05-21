<%-- 
    Document   : profilo
    Created on : 4-mag-2017, 20.33.23
    Author     : Argio
--%>
<%@page import="amm.nerdbook.Classi.UtentiRegistratiFactory"%>
<%@page import="amm.nerdbook.Classi.UtentiRegistrati"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Nerdbook </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="ArgioluLaura">
        <meta name="keywords" content="Nerdbook social network amicizie foto like.">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div class="contenitore">
            <jsp:include page="header.jsp"/>
            <div class="corpo">
                <div class="corpo-social">
                    <div id="persone">
                        <p>PERSONE</p>
                        <p>Laura Argiolu</p>
                        <p>Aurora Russo</p>
                        <p>Federico Brunde</p>
                    </div>
                    <div id="gruppi">
                        <p>Gruppi</p> 
                        <p>Gli Esploratori</p>
                        <p>Gli Equilibristi</p>
                        <p>I Paracadutisti</p>
                    </div>
                </div>
                <div class="corpo-profilo">
                    <form  id="corpo" action="ModificaDatiProfilo" method="post">
                        <div class="profilo-riga">
                            <div class="profilo-riga-label">  
                            <label>Nome Utente:</label>
                            </div>
                            <div class="profilo-riga-input">
                                <input name="nome" type="text" id="nome" placeholder="Inserisci Nome" value="${datiProfilo.nome}" required>     
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                            <label>Cognome Utente:</label>
                            </div>
                            <div class="profilo-riga-input">
                                <input name="cognome" type="text" id="cognome" placeholder="Inserisci cognome" value="${datiProfilo.cognome}" required>  
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                <label>Inserisci URL immagine profilo:</label>     
                            </div>
                            <div class="profilo-riga-input">
                                <input type="url" name="imgURL" id="imgURL" value="${datiProfilo.imgProfilo}" required/>
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                <label>Inserisci frase di presentazione:</label>     
                            </div>
                            <div class="profilo-riga-input">
                                <textarea name="frasepres" id="frasepres" rows="5" cols="25">${datiProfilo.frasePres}</textarea>
                            </div>
                        </div>   
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                <label>Inserisci data di nascita:</label>     
                            </div>
                            <div class="profilo-riga-input">
                                <input type="date" name="datanasc" id="datanasc" value="${datiProfilo.dataNasc}">
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                <label>Password:</label> 
                            </div>
                            <div class="profilo-riga-input">
                                <input type="password" name="password" id ="password" value="${datiProfilo.password}">
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                <label for="password">Conferma Password:</label>
                            </div>
                            <div class="profilo-riga-input">
                                <input type="password" name="cpassword" id ="cpassword" value="${datiProfilo.password}" >
                            </div>
                        </div>
                        <div class="profilo-riga padding-left-10">
                            <button class="button-profilo button" type="submit">Conferma e invia</button> 
                        </div>                            
                    </form>
                </div> 
            </div>
        </div>
    </body>
</html>

