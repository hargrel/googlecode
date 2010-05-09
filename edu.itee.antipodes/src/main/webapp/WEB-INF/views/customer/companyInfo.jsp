<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/polylines.js"/>"></script>
</head>

<body onunload="GUnload()">

<h2><c:out value="${listedTours[0].operator.operatorName}" /></h2>

<table border="0" align="center" width=100% style="border-collapse:collapse">
	<tr>
		<td valign="top"><h4>Company Info: </h4></td>
		<td valign="top"><h4><c:out value="${listedTours[0].operator.companyInfo}" escapeXml="false"/></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Membership Expired: </h4></td>
		<td valign="top"><h4><c:out value="${listedTours[0].operator.membershipExpired}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Email: </h4></td>
		<td valign="top"><h4><c:out value="${listedTours[0].operator.email}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Currency: </h4></td>
		<td valign="top"><h4><c:out value="${listedTours[0].operator.currency}" /></h4></td>
	</tr>

	<!--  
	<tr>
		<td valign="top"><h4>Company Info: <c:out value="${listedTours[0].operator.companyInfo}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Membership Expired: <c:out value="${listedTours[0].operator.membershipExpired}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Email: <c:out value="${listedTours[0].operator.email}" /></h4></td>
	</tr>
	<tr>
		<td valign="top"><h4>Currency: <c:out value="${listedTours[0].operator.currency}" /></h4></td>
	</tr>
	-->
	<input type="button" value="Contact Tour Operator" 
		onClick="window.location.href='<c:url value="contactTourOperator.html"/>'" 
		style="float: right; margin-right: 20px; margin-top: 10px;"/>
</table>

<h3>List of tours:</h3>
	<div id="Table">
	<table style="width: 800px;">
		<thead>
		<tr>
			<th>Tour Name</th>
			<th>Tour Price</th>
			<th>Start Date</th>
			<th>Finish Date</th>
			<th>Total Days</th>
			<th>More Info</th>
		</tr>
		</thead>
		<tbody>

		<c:forEach items="${listedTours}" var="listedTour">
			<c:forEach items="${listedTour.tour.tourDates}" var="tourDate">
				<tr>
					<td><c:out value="${listedTour.tour.tourName}" /></td>
					<td><c:out value="${listedTour.tour.price}" /></td>
					<td><c:out value="${tourDate.startDate}" /></td>
					<td><c:out value="${tourDate.finishDate}" /></td>
					<td><c:out value="${listedTour.tour.totalDays}" /></td>
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
	</div>
</body>
</html>
