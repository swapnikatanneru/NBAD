<%-- 
    Document   : editstudy
    Created on : Sep 22, 2015, 4:45:20 PM
    Author     : swapnika
--%>

<jsp:include page="/headerl.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="recommend">    
    <p id="clabel"><strong>Editing a study</strong></p><br>
</div>
<div class="clink"><p id="rlabel"><a href="rep?page=main" target="_self"><strong>&lt;&lt;  Back to the Main Page</strong></a></p></div>

<div class="site_content_signup">
       
  <form name="newstudy" action="study?page=update" method="POST">
     
     <label>Study Name*</label><input id="studyname" type="text" name="studyname" value='<c:out value="${study.getName()}" default="" />' /><br>
     <label>Question Text*</label><input id="question" type="text" name="Question*" value='<c:out value="${study.getQuestion()}" default="" />' /><br>
     <label>Image*</label> <img src='<c:out value="${study.getImageURL()}" default="" />' alt="library" width="80" height="42">
     <input id="image" type="file" name="image"/><br>
     <label>Participants*</label><input id="participants" type="text" name="participants*" value='<c:out value="${study.getRequestedparticipants()}" default="" />'/><br>
     <input type="hidden" name="Studycode" value='<c:out value="${study.code}" default="" />'/>
     <label>Description*</label><textarea name="description" rows="15" cols="20" placeholder='<c:out value="${study.getDescription()}" default="" />'></textarea><br>
     <input id="editstudy_update"  type="submit" value="Update" name="update" />
     
    </form>  
    
</div>



<jsp:include page="/footer.jsp" />