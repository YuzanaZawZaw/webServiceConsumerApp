<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Web Service Client Home Page(SpringMVC)</h3>
<font color='blue'>${message}</font>
<c:if test="${empty ulist}">NO USERS</c:if>
<c:if test="${not empty ulist}">
	<table border="1" width="100%">
		<tr><th>No</th><th>User Id</th><th>User Name</th>
			<th>User Age</th><th>User Salary</th>
		</tr>
		<c:forEach var="u" items="${ulist}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>user_id(${u.userId})</td>
				<td>${u.userName}</td>
				<td>${u.userAge}</td>
				<td>${u.userSalary}</td>
			</tr>
		</c:forEach>	
	</table>
</c:if>