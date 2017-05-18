<%-- 
    Document   : login
    Created on : 12-mag-2017, 13.36.06
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it">
    <head>
        <title> Nerdbook </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="ArgioluLaura">
        <meta name="keywords" content="Nerdbook social network amicizie foto like.">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <body>
        <header>
            <div id="title">
                <h1> Nerdbook </h1> 
            </div>
        </header>
        <div class="login">
            <div>
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">I dati inseriti non sono corretti!!</div>
                </c:if>
                <form action="Login" method="post">
                    <div class="profilo-riga">
                        <div class="profilo-riga-label margin-bottom-2em"> 
                            <label for="username">UserName</label>
                        </div>
                        <div class="profilo-riga-input margin-bottom-2em">
                            <input type="text" name="username" id ="username" value="">
                        </div>
                    </div>
                    <div class="profilo-riga">
                        <div class="profilo-riga-label margin-bottom-2em"> 
                            <label for="password">Password</label>
                        </div>
                        <div class="profilo-riga-input margin-bottom-2em">
                            <input type="password" name="password" id ="password" value="">
                        </div>
                    </div>
                    <div class="profilo-riga padding-left-10">
                        <button class="button-login button" type="submit">Login</button> 
                    </div>
                </form>

            </div>
        </div>
      
    </body>
</html>

