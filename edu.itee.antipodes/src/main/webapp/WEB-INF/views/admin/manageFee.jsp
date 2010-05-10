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
<h2>Manage Fees</h2>
<div id="Table">
<table style="width: 100%;">
	<thead>
	<tr>
		<th style="width: 60px;">ListID</th>
		<th>OperatorID</th>
		<th>TourID</th>
		<th>From</th>
		<th>To</th>
		<th>Total Fee</th>
		<th></th>
	</tr>
	</thead>

	<tbody>
	<c:forEach items="${listedTours}" var="listedTour">
		
		<tr>
			<td><c:out value="${listedTour[0]}" /></td>
			<td><c:out value="${listedTour[1]}" /></td>
			<td><c:out value="${listedTour[2]}" /></td>
			<td><c:out value="${listedTour[3]}" /></td>
			<td><c:out value="${listedTour[4]}" /></td>
			<td><c:out value="${listedTour[5]}" /></td>
			<td>
				<form style="margin:0px; padding: 0px;" name="manage_${listedTour[0]}" action="feeList.html" method="get">
				<input type="hidden" name="listID" value="${listedTour[0]}" />
				</form>
				<a href="#" style="color: blue" onclick="document['manage_${listedTour[0]}'].submit()">Manage</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>

</table>
<input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" style="float: right; margin-right: 20px; margin-top: 10px;"/>
</div>
</body>
</html>