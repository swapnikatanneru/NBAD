<%-- 
    Document   : recommend
    Created on : Sep 22, 2015, 4:43:59 PM
    Author     : swapnika
--%>

<jsp:include page="/headerl.jsp" />

<div class="recommend">
    
    <p id="clabel"><strong>Recommend to a friend</strong></p><br>
</div>
<div class="clink"><p id="rlabel"><a href="rep?page=main" target="_self"><strong>&lt;&lt; Back to the Main Page</strong></a></p></div>

<div class="site_content_signup">
       
  <form name="recommend" action="EmailListServlet" method="POST">
           <input type="hidden" name="action" value="sendrecommendInfo">

     <label>Name*</label><input id="username" type="text" name="rusername" required /><br>
     <label>Email*</label><input id="email" type="text" name="Email*" required/><br>
     <label>Friend's Email*</label><input id="femail" type="text" name="Femail*" required/><br>
     <label>Message*</label><textarea name="rmessage" rows="15" cols="20" required></textarea><br>
     <input id="signup_submit" type="submit" value="Submit" name="submit" />
    </form>  
    <h2 > <i>When your friend logs in and participates in one user study, you'll get 2 coins bonus </i></h2>
</div>
   

<jsp:include page="/footer.jsp" />