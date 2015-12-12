<%-- 
    Document   : participate
    Created on : Sep 22, 2015, 4:45:38 PM
    Author     : swapnika
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/headerl.jsp" />


<jsp:include page="/left_menu.jsp" />
    

<div class="studies">
    <div class="recommend">
    
    <p id="clabel"><strong>Studies</strong></p><br>
    </div>
    
    <table>
    <tr >
        <th>Study Name</th>
        <th>Image</th>
        <th>Question</th>
        <th>Action</th>
        
    </tr>
    <c:forEach var="Study" items="${studies}" varStatus="itr">
        <form name="participate" action="study" method="POST">
        <input type="hidden" name="page" value="participate">
        <input type="hidden" name="Studycode" value="${Study.code}"/>
    <tr class="${itr.index % 2 == 0 ? 'trodd' : 'treven'}">
        <td>${Study.getName()}</td>
        <td><img src="${Study.getImageURL()}" alt="${Study.getName()}" width="35" height="35"></td>
        <td>${Study.getQuestion()}</td>
        <td><button class="participate" type="submit" value="participate" name="Participate" />Participate</button></td>
   
        </tr> 
        </form>
    </c:forEach>
        <%--
        
    <tr class="treven">
        <td>Sec</td>
        <td><img src="media/sticky.jpg" alt="sticky" width="35" height="35"></td>
        <td>I use computers on daily basis</td>
        <td><input id="participate1" type="submit" value="participate" name="Participate" /></td>
    </tr>
    <tr class="trodd">
        <td>GUI</td>
        <td><img src="media/library.jpg" alt="library" width="35" height="35"></td>
        <td>I enjoy outdoor activities</td>
        <td><input id="participate" type="submit" value="participate" name="Participate" /></td>
        
    </tr>
    <tr class="treven">
        <td> </td>
        <td> </td>
        <td> </td>
        <td> </td>
        
    </tr>
        
        
        --%>
        
    </table>

</div>



<jsp:include page="/footer.jsp" />

