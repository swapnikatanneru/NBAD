<%-- 
    Document   : left_menu
    Created on : Sep 26, 2015, 1:46:35 PM
    Author     : swapnika
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="site_left_menu">

    <div class="menu_item">

        <%-- <c:choose>
            <c:when test="${theUser.Coins != null}">
                <p>Coins(${theUser.Coins})</p>
            </c:when>
            <c:otherwise>

            </c:otherwise>
</c:choose> --%>

          <p>Coins(<c:out value="${theUser.getCoins()}" default="" />)</p>
       
        

    </div>
    <div class="menu_item">
        
        
     
           <p>Participants(<c:out value="${theUser.getParticipants()}" default="" />)</p>
        
        
    </div>
    <div class="menu_item">
       
              
        <p>Participation(<c:out value="${theUser.getParticipation()}" default="" />)</p>
       
       
    </div>
    <div class="menu_item">
        <p></p>
    </div>
    <div class="menu_item">
        <p><a href="rep?page=main" target="_self">Home</a></p>
    </div>
    <div class="menu_item">
        <p><a href ="study?page=participate" target ="_self">Participate</a></p>
    </div>
    <div class="menu_item">
        <p><a href ="study?page=studies" target ="_self">My Studies</a></p>
    </div>
    <div class="menu_item">
        <p><a href ="rep?page=recommend" target="_self">Recommend</a></p>
    </div>
    <div class="menu_item">
        <p><a href="rep?page=contact" target="_self">Contact</a></p>
    </div>
    <div class="menu_item2">
        <p><a href="rep?page=home" target="_self">Log out</a></p>
    </div>
</div>