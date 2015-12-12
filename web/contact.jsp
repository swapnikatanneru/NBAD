<%-- 
    Document   : contact
    Created on : Sep 22, 2015, 4:43:23 PM
    Author     : swapnika
--%>

<jsp:include page="/header.jsp" />



<div class="contact">
    
    <p id="clabel"><strong>Contact</strong></p><br>
</div>

<div class="clink"><p id="rlabel"><a href="rep?page=main" target="_self"><strong>&lt;&lt; Back to the Main Page</strong></a></p></div>
<div class="site_content_signup">
    
    
  <form name="contact" action="EmailListServlet" method="POST">
      <input type="hidden" name="action" value="sendContactInfo">
     
     <label>Name*</label><input id="username" type="text" name="username" /><br>
     <label>Email Address*</label><input id="email" type="text" name="EmailAddress*" /><br>
     <label>Message*</label><textarea name="message" rows="15" cols="20"></textarea><br>
     <input id="signup_submit" type="submit" value="Submit" name="submit" />
    </form>  
    
    
    
</div>


<jsp:include page="/footer.jsp" />