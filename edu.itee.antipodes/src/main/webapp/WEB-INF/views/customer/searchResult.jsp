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

<h2>Search Results</h2>
	<div id="Table">
	<table style="width: 800px;">
		<thead>
		<tr>
			<!--  
			<th>Name</th>
			<th>Location</th>
			<th>Activity</th>
			<th>Duration</th>
			<th>Start date</th>
			<th>Finish date</th>
			<th>Price</th>
			<th></th>
			-->
			<th>Name</th>
			<th>Description</th>
			<th>Duration</th>
			<th>Price</th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${tours}" var="tour">
			<tr>
				<td><c:out value="${tour.tourName}" /></td>
				<td><c:out value="${tour.tourDesc}" /></td>
				<td><c:out value="${tour.totalDays}" /></td>
				<td><c:out value="${tour.price}" /></td>			
 	
				<td>
					<form style="margin:0px; padding: 0px;" name="info_${tour.tourID}" action="tourInfo.html" method="get">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['info_${tour.tourID}'].submit()">More Info</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="Back" onClick="window.location.href='<c:url value="search.html"/>'" style="float: right; margin-right: 20px; margin-top: 10px;"/>
	</div>
</body>
</html>