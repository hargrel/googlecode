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

	<h2>Align Tour List</h2>
	<div id="Table">
	<table width=100%>
		<thead>
		<tr>
			<th>ID</th>
			<th>Tour Name</th>
			<th>Location</th>
			<th>Activity</th>
			<th>Start Date</th>
			<th>Finish Date</th>
			<th>Duration</th>
			<th></th>	
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${tours}" var="tour">
			
			<tr>
				<td><c:out value="${tour.tourID}" /></td>
				<td><c:out value="${tour.tourName}" /></td>	
				<td><c:out value="${location.locationName}" /></td>
				<td><c:out value="${activity.activityName}" /></td>	
				<td><c:out value="${tourdate.startDate}" /></td>
				<td><c:out value="${tourdate.finishDate}" /></td>
				<td><c:out value="${tour.totalDays}" />&nbsp; days</td>		
				<td>
					<form style="margin:0px; padding: 0px;" name="align_${tour.tourID}" action="alignTour.html" method="get">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['align_${tour.tourID}'].submit()">Align</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</body>
</html>