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
	
	<h2>Global List of Activities</h2>
	<div id="Table">
	<table style="width: 500px;">
		<thead>
		<tr>
			<th style="width: 80px;">Activity ID</th>
			<th>Activity Name</th>
			<th></th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${activity}" var="activity">
			
			<tr>
				<td><c:out value="${activity.activityID}" /></td>
				<td><c:out value="${activity.activityName}" /></td>			
				<td>
					<form style="margin:0px; padding: 0px;" name="edit_${activity.activityID}" action="editGlobalListActivity.html" method="get">
						<input type="hidden" name="userID" value="${activity.activityID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${activity.activityID}'].submit()">Edit</a>
				</td>
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${activity.activityID}" action="globalListActivity.html" method="post">
						<input type="hidden" name="tourID" value="${activity.activityID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['delete_${activity.activityID}'].submit()">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	<input type="button" value="Cancel" onClick="window.location.href='<c:url value="maintainSearchCriteria.html"/>'" style="float: right; margin-right: 320px; margin-top: 10px;"/>
	</div>
	
	
</body>
</html>