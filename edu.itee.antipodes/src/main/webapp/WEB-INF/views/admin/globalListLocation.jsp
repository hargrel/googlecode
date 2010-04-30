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

<h2>Global List of Locations</h2>
	<div id="Table">
	<table style="width: 500px;">
		<thead>
		<tr>
			<th style="width: 80px;">Location ID</th>
			<th>Location Name</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		
		<c:forEach items="${locations}" var="location">
			
			<tr>
				<td><c:out value="${location.locationID}" /></td>
				<td><c:out value="${location.locationName}" /></td>			
				<td>
					<form style="margin:0px; padding: 0px;" name="edit_${location.locationID}" action="editGlobalListLocation.html" method="get">
						<input type="hidden" name="tourID" value="${location.locationID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${location.locationID}'].submit()">Edit</a>
				</td>
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${location.locationID}" action="globalListLocation.html" method="post">
						<input type="hidden" name="tourID" value="${location.locationID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['delete_${location.locationID}'].submit()">Delete</a>
				</td>
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${location.locationID}" action="maintainLink.html" method="post">
						<input type="hidden" name="tourID" value="${location.locationID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${location.locationID}'].submit()">Interactive Map</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	</div>
	<input type="button" value="Cancel" onClick="window.location.href='<c:url value="maintainSearchCriteria.html"/>'" style="float: right; margin-right: 320px; margin-top: 10px;"/>


</body>
</html>