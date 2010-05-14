<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.desc {
	margin-top: 20px;
	font-size: 12px;
	color: black;
}

</style>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/tourInfo.js"/>"></script>
</head>

<body onload="initialize()" onunload="GUnload()">
<h2><c:out value="${listedTour.tour.tourName}" /></h2>
<table border="0" align="center" width=100% style="border-collapse:collapse">
	
	<tr>
		<!-- Google Map -->
		<td rowspan="5" valign="top" width=35% ><div id="map_canvas" style="width: 500px; height: 300px; margin-right:20px"></div></td>
		
		<!-- Price -->
		<td valign="top"><b>Price:</b>&nbsp;&nbsp;<c:out value="${listedTour.tour.price}" />&nbsp;<c:out value="${listedTour.tour.currency}" /></td>
	</tr>
		<!-- Dates -->
	<!-- not working for multiple dates -->
	<c:forEach items="${listedTour.tour.tourDates}" var="tourDate">
		<tr>
			<td valign="top"><b>Start Date:</b>&nbsp;&nbsp; <c:out value="${tourDate.startDate}" /></td>
		</tr>
		<tr>
			<td valign="top"><b>Finish Date:</b>&nbsp;&nbsp;<c:out value="${tourDate.finishDate}" /></td>
		</tr>
	</c:forEach>
	
	<tr>
		<td valign="top">
			<b>Tour Operator:</b>&nbsp;&nbsp;
			<a href="#" style="color: blue;" 
			onclick="document['company info_${listedTour.operator.operatorID}'].submit()"><c:out value="${listedTour.operator.operatorName}" /></a>
			<form style="margin:0px; padding:0px;" name="company info_${listedTour.operator.operatorID}" 
				action="companyInfo.html" method="post">
				<input type="hidden" name="operatorID" value="${listedTour.operator.operatorID}" />
			</form>
			
		</td>
	</tr>
	<tr>
		<td><input type="button" value="Contact Tour Operator" style="margin-top: 50px" onClick="window.location.href='<c:url value="contactTourOperator.html"/>'"/></td>
	</tr>
</table>

<div class="desc">
<h4>Location:</h4>
<h4>Activity:</h4>
<h4>Description:</h4>
<c:out value="${listedTour.tour.tourDesc}" escapeXml="false"/>

<h4>Images:</h4>
</div>
</body>
</html>