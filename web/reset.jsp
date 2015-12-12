<%-- 
    Document   : signup
    Created on : Sep 22, 2015, 4:41:44 PM
    Author     : swapnika
--%>

<jsp:include page="/header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="site_content_signup">
    
    
     <form name="signup" action="rep?page=reset" method="POST">
         <br/><br/><br/><br/><br/>
     
     <label>Email Address*</label><input id="email" type="text" name="EmailAddress*" value='<c:out value="${email}" default="" />' required/><br><br/><br/>
     <label>Password*</label><input id="password" type="password" name="Password*" value=""  required/><br><br/><br/>
     <label>Confirm Password*</label><input id="cpassword" type="password" name="cPassword*" value="" required /><br>
     <input type="hidden" name="token" value='<c:out value="${token}" default="" />'/>
     <input type="hidden" name="resetflag" value="reset"/>

     <p><c:out value="${errorr}" default="" /> <c:out value="${msg}" default="" /></p><br/>
     
     <input id="signup_submit" type="submit" value="Create Account" name="createaccount" />
    </form>
    
    
    
</div>


<jsp:include page="/footer.jsp" />