<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Delete Account</h2>
	<div id="Table">
	<table style="width: 800px;">
		<thead>
		<tr>
			<th style="width: 60px;">User ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>User Type</th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${accounts}" var="account">
			
			<tr>
				<td><c:out value="${account.userID}" /></td>
				<td><c:out value="${account.userName}" /></td>
				<td><c:out value="${account.password}" /></td>
				<td><c:out value="${account.userType}" /></td>
			
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${account.userID}" action="deleteAccount.html" method="post">
						<input type="hidden" name="tourID" value="${account.userID}" />
					</form>
					<a href="#" style="color: blue" onclick="document['delete_${account.userID}'].submit()">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	<input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" style="float: right; margin-right: 20px; margin-top: 10px;"/>
	</div>
	
</body>
</html>