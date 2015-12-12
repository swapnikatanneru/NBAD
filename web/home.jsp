<%-- 
    Document   : home
    Created on : Sep 22, 2015, 4:41:07 PM
    Author     : swapnika
--%>
<jsp:include page="/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
<jsp:include page="/left_menu.jsp" />

--%>
<div class="site_content_home">
    
    <% 
     
                Cookie cookie = new Cookie("host",request.getLocalName());
                Cookie port = new Cookie("port",String.valueOf(request.getLocalPort()));
                 
            cookie.setMaxAge(24*60*60);
            port.setMaxAge(24*60*60);
            response.addCookie(cookie); 
             response.addCookie(port); 
    
    
    %>
    <c:forEach var="item" begin="0" end="20" step="6"> 

${item} 

</c:forEach>
    
</div>


<jsp:include page="/footer.jsp" />