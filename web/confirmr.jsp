<%-- 
    Document   : confirmr
    Created on : Sep 22, 2015, 4:44:20 PM
    Author     : swapnika
--%>

<jsp:include page="/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="clink"><p id="rlabel"><a href="rep?page=main" target="_self"><strong>&lt;&lt;Back to the Main Page</strong></a></p></div>

<div class="site_content_signup">
    <p> <c:out value="${outmessage}" default="" /> </p>
</div>


<jsp:include page="/footer.jsp" />