<%-- 
    Document   : login
    Created on : Sep 22, 2015, 4:41:23 PM
    Author     : swapnika
--%>

<jsp:include page="/header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="site_content_login">
    <br/><br/><br/>
    <form name="login" action="rep?page=login" method="POST">
     <label>Email Address*</label><input id="email" type="text" name="EmailAddress*" required/><br/><br/>
     <label>Password*</label><input id="password" type="password" name="Password*" value="" required /><br/><br/>
     <input type="submit" value="Log in" name="Log in" />
    </form>
    
    <p><c:out value="${error}" default="" /> <c:out value="${outmessage}" default="" /></p><br/>
    
    <p id="signup1"><a href="signup.jsp" target="_self"><strong>Sign up for a new account</strong></a></p>
    <p id="signupf"><a href="rep?page=forgot" target="_self"><strong>Forgot password</strong></a></p>
    
    
</div>


<jsp:include page="/footer.jsp" />