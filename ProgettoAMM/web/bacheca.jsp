<%-- 
    Document   : bacheca
    Created on : 4-mag-2017, 12.46.46
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title> Nerdbook </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="ArgioluLaura">
        <meta name="keywords" content="Nerdbook social network amicizie foto like.">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script language="javascript" type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script language="javascript" type="text/javascript" src="js/RicercaAjax.js"></script>
    </head>    
    <body>    
        <div class="contenitore">
            <jsp:include page="header.jsp"/>
            <div class="corpo">
                <jsp:include page="barraLaterale.jsp"/>
                <div class="corpo-profilo">
                    <div id="post" <p>Bacheca di ${utente.nome} ${utente.cognome}</p> </div>
                    <div id="frase" <p>${utente.frasePres}</p> </div>

                     <jsp:include page="nuovoPost.jsp"/>
                    
                    <c:forEach var="post" items="${posts}">
                    
                    
                    <div class="post">
                        <img class="imgProfile" alt="Foto Profilo" src="${utente.imgProfilo}" width="150" height="150">
                        <h2 class="nomeUtente">${utente.nome} ${utente.cognome}</h2>
                        <p>${post.testo}</p>
                        <c:if test="${post.postType == 'IMAGE'}">
                            <img alt="Post con foto" src="${post.content}">
                        </c:if>
                        <c:if test="${post.postType == 'URL'}">
                            <a href="${post.content}">${post.content}</a>
                        </c:if>                             
                    </div>
                     </c:forEach>
                </div>               
            </div>
        </div>
    </body>
    
</html>