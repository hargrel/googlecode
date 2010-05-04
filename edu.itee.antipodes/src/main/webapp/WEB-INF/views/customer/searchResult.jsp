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
			<th>Tour Name</th>
			<th>Operator Name</th>
			<th>Start Date</th>
			<th>Finish Date</th>
			<th>Tour Price</th>
			<th>More Info</th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${listedTours}" var="listedTour">
			<c:forEach items="${listedTour.tour.tourDates}" var="tourDate">
				<tr>
					<td><c:out value="${listedTour.tour.tourName}" /></td>
					<td><c:out value="${listedTour.operator.operatorName}" /></td>
					<td><c:out value="${tourDate.startDate}" /></td>
					<td><c:out value="${tourDate.finishDate}" /></td>
					<td><c:out value="${listedTour.tour.price}" /></td>
					<td>
						<form style="margin:0px; padding: 0px;" name="info_${listedTour.listID}" 
							action="tourInfo.html" method="post">
							<input type="hidden" name="listID" value="${listedTour.listID}" />
						</form>
						<a href="#" style="color: blue;" 
							onclick="document['info_${listedTour.listID}'].submit()">info</a>
					</td>
				</tr>
			</c:forEach>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="Back" onClick="window.location.href='<c:url value="search.html"/>'" 
		style="float: right; margin-right: 20px; margin-top: 10px;"/>
	</div>
</body>
</html>