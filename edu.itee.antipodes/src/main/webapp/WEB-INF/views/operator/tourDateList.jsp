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

	<h2>Tour Dates List</h2>
	<div id="Table">
	<table style="width: 750px;">
		<thead>
		<tr>
			<th>Date ID</th>
			<th>Start Date</th>
			<th>Finish Date</th>
			<th></th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${dates}" var="date">
			
			<tr>
				<td><c:out value="${date.dateID}" /></td>
				<td><c:out value="${date.startDate}" /></td>	
				<td><c:out value="${date.finishDate}" /></td>
				<td>
					<form style="margin:0px; padding: 0px;" name="edit_${date.dateID}" action="editDate.html" method="get">
						<input type="hidden" name="dateID" value="${date.dateID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${date.dateID}'].submit()">Edit</a>
				</td>
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${date.dateID}" action="tourDateList.html" method="post">
						<input type="hidden" name="tourID" value="${date.dateID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['delete_${date.dateID}'].submit()">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	<input type="button" value="Add" onClick="window.location.href='<c:url value="addTourDate.html"/>'" />
</div>
</body>
</html>