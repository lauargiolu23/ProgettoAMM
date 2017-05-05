<%-- 
    Document   : profilo
    Created on : 4-mag-2017, 20.33.23
    Author     : Argio
--%>
<%@page import="amm.nerdbook.Classi.UtentiRegistratiFactory"%>
<%@page import="amm.nerdbook.Classi.UtentiRegistrati"%>
<%
    UtentiRegistrati utente = new UtentiRegistrati();
    
    utente.setNome("Laura");
    utente.setCognome("Argiolu");
%>

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
            <div class="barraTop ">
                <div class="barraTop-logo barraTopColor">
                    NerdBook
                </div>
                <div class="barraTop-navigazione barraTopColor" >
                        <nav id="menu">
                            <ul>
                                <li> <p> <a href="profilo.html">Profilo</a></p></li> 
                                <li> <p> <a href="bacheca.html">Bacheca</a></li>  
                            </ul>
                        </nav>
                </div>
                <div class="barraTop-log barraTopColor">
                    <a href="login.html">Login</a>
                </div>
            </div>
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
                    <form  id="corpo" action="profilo.php" method="post">
                        <div class="profilo-riga">
                            <div class="profilo-riga-label">  
                                Nome Utente
                            </div>
                            <div class="profilo-riga-input">
                                <input name="nome" type="text" id="nome" placeholder="Inserisci Nome" value="<% out.print(utente.getNome()); %>" required>     
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                Cognome Utente
                            </div>
                            <div class="profilo-riga-input">
                                <input name="cognome" type="text" id="cognome" placeholder="Inserisci cognome" value="<% out.print(utente.getCognome()); %>" required>  
                        
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                Inserisci URL immagine profilo 
                            </div>
                            <div class="profilo-riga-input">
                                <input type="url" name="imgURL" id="imgURL" required/>
                        
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                Inserisci frase di presentazione:
                            </div>
                            <div class="profilo-riga-input">
                                <textarea name="frasepres" id="frasepres" rows="5" cols="25"></textarea>
                            </div>
                        </div>   
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                Inserisci data di nascita
                            </div>
                            <div class="profilo-riga-input">
                                <input type="date" name="datanasc" id="datanasc">
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                Password
                            </div>
                            <div class="profilo-riga-input">
                                <input type="password" name="password" id ="password" value="">
                            </div>
                        </div>
                        <div class="profilo-riga">
                            <div class="profilo-riga-label"> 
                                Conferma Password
                            </div>
                            <div class="profilo-riga-input">
                                <input type="password" name="cpassword" id ="cpassword" >
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

