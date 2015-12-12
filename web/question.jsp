<%-- 
    Document   : question
    Created on : Sep 22, 2015, 4:46:03 PM
    Author     : swapnika
--%>

<jsp:include page="/headerl.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/left_menu.jsp" />


  <form name="newstudy" action="study?page=answer" method="POST">

<div class="site_content">
    <div class="recommend">
    
    <p id="clabel"><strong>Question</strong></p><br>
</div>
<img src="media/tree.png" alt="tree" width="150" height="300">   
<input type="hidden" name="Studycode" value='<c:out value="${study.getCode()}" default="" />'/>
<p><c:out value="${study.getQuestion()}" default="" /> (1 strongly agree - 7 strongly disagree) </p>
<select name="choice">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
</select> 
<input id="signup_submit" type="submit" value="Submit" name="submit" />
    
</div>
  </form>

<jsp:include page="/footer.jsp" />