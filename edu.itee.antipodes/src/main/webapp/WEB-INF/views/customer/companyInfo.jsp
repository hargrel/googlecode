<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="js/polylines.js"></script>
</head>

<body onunload="GUnload()">

<h2>[TourOperatorName]<c:out value="${TourOperator.operatorName}" /></h2>

<table border="0" align="center" width=100% style="border-collapse:collapse">
	<tr>
		<td valign="top"><h4>Address: <c:out value="${TourOperator.address}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Telephone: <c:out value="${TourOperator.telephone}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Description: <c:out value="${TourOperator.description}" /></h4></td>
	</tr>
	<input type="button" value="Contact Tour Operator" onClick="window.location.href='<c:url value="contactTourOperator.html"/>'" style="float: right; margin-right: 20px; margin-top: 10px;"/>
</table>
<h3>List of tours:</h3>
	<div id="Table">
	<table style="width: 800px;">
		<thead>
		<tr>
			<!-- edited for testing -->
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Total days</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${tours}" var="tour">
			<tr>
				<td><c:out value="${tour.tourName}" /></td>
				<td><c:out value="${tour.tourDesc}" /></td>
				<td><c:out value="${tour.price}" /></td>
				<td><c:out value="${tour.totalDays}" /></td>
				<td>
					<a href="#" style="color: blue;" onclick="">More Info</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>