<%-- 
    Document   : barraLaterale
    Created on : 12-mag-2017, 14.24.38
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<div class="corpo-social">
    <div id="searchUtente">
        <input id="search" type="text" placeholder="search your User!" value="">
        <button id="idbottone">Ricerca Utente</button>
    </div>
    <div id="usersList">
        <p></p>
    </div>
    <div id="persone">
        <p>PERSONE</p>
        <c:forEach var="utenti" items="${utenti}">
            <p> <a href="Bacheca?user=${utenti.id}">${utenti.nome}${utenti.cognome}</a>  </p>
        </c:forEach>
    </div>
    <div id="gruppi">
        <p>Gruppi</p> 
        <c:forEach var="gruppi" items="${gruppi}">
        ///
        <p>${gruppi.nome}</p> 
        </c:forEach>
        
    </div>
</div>
