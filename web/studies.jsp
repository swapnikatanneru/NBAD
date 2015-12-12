<%-- 
    Document   : studies
    Created on : Sep 22, 2015, 4:44:43 PM
    Author     : swapnika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/headerl.jsp" />


<div class="clink">
    
     <p id="rlabel"> <a href="study?page=add">
            <strong>Add a new study</strong>    </a>    </p>
    <br/> <br/>  <p id="rlabel1"> <a href="rep?page=main">
            <strong>&lt;&lt; Back to the Main Page</strong>    </a>    </p>
</div>
<div class="studies">
    
    <table>
    <tr>
        <th>Study Name</th>
        <th>Requested Participants</th>
        <th>Participations</th>
        <th>Status</th>
        <th>Action</th>
        
    </tr>
    <c:forEach var="Study" items="${studies}" varStatus="itr">
    <tr class="${itr.index % 2 == 0 ? 'trodd' : 'treven'}">
        <form name="participate" action="study" method="POST">		
        <input type="hidden" name="page" value="editstudy">
        <td><c:out value="${Study.getName()}" default="" /></td>
        <td><c:out value="${Study.getRequestedparticipants()}" default="" /></td>
        <td><c:out value="${Study.getNumofparitipants()}" default="" /></td>
        <td><input type="hidden" name="Studycode" value='<c:out value="${Study.code}" default="" />'/><button class="start_study" formaction="study?page=studyStatus" type="submit" value="${Study.getStatus()}" name="Status" />${Study.getStatus()}</button></td>
        <td><button class="edit_study" formaction="study?page=editStudy" type="submit" value="Edit" name="Edit" />Edit</button></td>  
    </form>
        </tr>
    </c:forEach>
    
    <%--
    <tr class="treven">
        <td>Sec</td>
        <td>5</td>
        <td>5</td>
        <td><input id="stop_study" type="button" value="Stop" name="Stop" /></td>
        <td><input id="edit_study1" type="submit" value="Edit" name="Edit" /></td>  
    </tr>
    <tr class="trodd">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>  
    </tr>
    <tr class="treven">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>  
    </tr>
    
    --%>
    </table>
    
</div>



<jsp:include page="/footer.jsp" />
