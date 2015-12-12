<%-- 
    Document   : newstudy
    Created on : Sep 22, 2015, 4:44:58 PM
    Author     : swapnika
--%>

<jsp:include page="/headerl.jsp" />
<div class="recommend">    
    <p id="clabel"><strong>Adding a study</strong></p><br>
</div>
<div class="clink"><p id="rlabel"><a href="rep?page=main" target="_self"><strong>&lt;&lt;  Back to the Main Page</strong></a></p></div>

<div class="site_content_signup">
       
  <form name="newstudy" action="study?page=newstudy" method="POST">
     
     <label>Study Name*</label><input id="studyname" type="text" name="studyname" required /><br>
     <label>Question Text*</label><input id="question" type="text" name="Question*" required/><br>
     <label>Image*</label><input id="image" type="file" name="image"/><p>            </p><br>
     <label>Participants*</label><input id="participants" type="text" name="participants*" required /><br>
     <label>Description*</label><textarea name="description" rows="15" cols="20" required></textarea><br>
     <input id="newstudy_submit" type="submit" value="Submit" name="submit" />
    </form>  
    
</div>


<jsp:include page="/footer.jsp" />