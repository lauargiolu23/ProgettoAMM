<%-- 
    Document   : nuovoPost
    Created on : 26-giu-2017, 15.45.03
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<div id="post">
    <c:choose>
        <c:when test="${empty newpost}">
            <div id="formNewPost">
                <form id="nuovoPost" action="InviaPost" method="post">
                    <div id="postType">
                        <p>Indica tipo di allegato:</p>
                        <div>
                            <label for="imgType">Foto</label>
                            <input type="radio" name="postType" value="imgType" id="imgType">
                        </div>
                        <div>
                            <label for="urlType">Url</label>
                            <input type="radio" name="postType" value="urlType" id="urlType">
                        </div>
                    </div>
                    <div id="postContent">
                        <div>
                            <label for="textPost">Inserisci URL del tuo allegato: </label>
                            <input name="textPost" id="textPost">
                            <label for="testo">Inserisci Testo</label>
                            <textarea name="testoType" id="testo"></textarea>
                        </div>
                    </div>
                    <button type="submit" name="thereIsPost" value="needConfirm">Invia post</button>
                </form>     
            </div>

        </c:when>
        <c:otherwise>
            <div class="post">
               <form action="InviaPost" method="post">
                    <c:if test="${typePost == 'textType'}">
                        <p>${text}</p>
                    </c:if>
                    <c:if test="${typePost == 'imgType'}">
                        <img src="${content}" alt="downloadedImage">
                        <p>${text}</p>
                    </c:if>
                    <c:if test="${typePost == 'urlType'}">
                        <a href="${content}">${content}</a>
                        <p>${text}</p>
                    </c:if>    
                    <input type="text" hidden name="textPost" value="${content}">
                    <input type="text" hidden name="postType" value="${typePost}">
                    <input type="text" hidden name="testoType" value="${text}">
                    <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                </form>                           
            </div>
        </c:otherwise>
    </c:choose>
</div>