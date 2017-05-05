<%-- 
    Document   : nav
    Created on : 5-mag-2017, 21.33.10
    Author     : Argio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav>
    <ul>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>><a href="profilo.html">Profilo</a></p></li> 
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="bacheca.html">Bacheca</a></li>  
    </ul>
</nav>
      