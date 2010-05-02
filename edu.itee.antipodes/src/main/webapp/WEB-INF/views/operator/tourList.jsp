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

	<h2>Tour List</h2>
	<div id="Table">
	<table style="width: 750px;">
		<thead>
		<tr>
			<th>ID</th>
			<th>Tour Name</th>
			<th>Description</th>
			<th>Price</th>
			<th></th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${tours}" var="tour">
			
			<tr>
				<td><c:out value="${tour.tourID}" /></td>
				<td><c:out value="${tour.tourName}" /></td>	
				<td><c:out value="${tour.tourDesc}" /></td>
				<td><c:out value="${tour.price}" /></td>
				<td>
					<form style="margin:0px; padding: 0px;" name="edit_${tour.tourID}" action="editTour.html" method="get">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${tour.tourID}'].submit()">Edit</a>
				</td>
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${tour.tourID}" action="tourList.html" method="post">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['delete_${tour.tourID}'].submit()">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</body>
</html>