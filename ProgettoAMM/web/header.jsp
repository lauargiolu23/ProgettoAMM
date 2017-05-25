<%-- 
    Document   : header
    Created on : 5-mag-2017, 21.41.02
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="barraTop ">
    <div class="barraTop-logo barraTopColor">
        NerdBook
    </div>
    <div class="barraTop-navigazione barraTopColor" >
            <nav id="menu">
                <ul>
                    <li> <p> <a href="Profilo">Profilo</a></p></li> 
                    <li> <p> <a href="Bacheca">Bacheca</a></li>  
                </ul>
            </nav>
    </div>
    <div class="barraTop-log barraTopColor">
       
        
        <%--Inserire il nome dell'utente loggato
            far funzionare login per aprire la sessione e poi logout per chiuderla....
        
        
        
        <p id="Name">
            <strong>Nome:</strong> 
                ${utenti.nome}
        </p>--%>
        <c:choose>
            <c:when test="${empty param.user}">
           <a href="Login?logout=1">Logout</a>
            </c:when>
            <c:otherwise>
           <a href="Login">Login</a>
            </c:otherwise>
        </c:choose>
           
<!--        <c:if test="{not empty param.user}">
            <a href="Login">Login</a>
        </c:if>
        <c:if test="{empty param.user}">
            <a href="Login?logout=1">Logout</a>
        </c:if>-->

    </div>
        
    
</div>
