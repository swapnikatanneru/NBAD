<%-- 
    Document   : signup
    Created on : Nov 22, 2015, 4:41:44 PM
    Author     : swapnika
--%>

<jsp:include page="/header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="site_content_signup">
    
    
     <form name="forgot" action="rep?page=forgot" method="POST">
         <br/><br/><br/><br/><br/>
         <p> Please enter your email for password reset instructions</p>
     <label>Email Address*</label><input id="email" type="text" name="EmailAddress*" required/><br><br/><br/>
     
     <p><c:out value="${errorf}" default="" /> <c:out value="${outmessage}" default="" /></p><br/>
     
     <input id="signup_submit" type="submit" value="Reset password" name="createaccount" />
     
    </form>
    
    
    
</div>


<jsp:include page="/footer.jsp" />