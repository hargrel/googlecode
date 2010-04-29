<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="js/polylines.js"></script>
</head>

<body onunload="GUnload()">
<!--  
<h2>[TourName]<c:out value="${tour.tourName}" /></h2>
-->
<h2><c:out value="${tour.tourName}" /></h2>
<table border="0" align="center" width=100% style="border-collapse:collapse">
	<tr>
		<td rowspan="5" valign="top" width=35% ><div id="map_canvas" style="width: 500px; height: 300px; margin-right:20px"></div></td>
		<td valign="top"><h4>Price: <c:out value="${tour.price}" /></h4></td>
	</tr>
	<!--  
	<tr>
		<td valign="top"><h4>Tour Operator: <c:out value="${TourOperator.operatorName}" /></h4></td>
	</tr>
	-->
	<!--  
	<tr>
		<td valign="top"><h4>Available dates: <c:out value="${TourDate.startDate}" /></h4></td>
	</tr>
	-->
	<tr>
  		<td valign="top"><h4>Duration: <c:out value="${tour.totalDays}" /></h4></td>
  	</tr>
  	
	<tr>
		<td><input type="button" value="Contact Tour Operator" onClick="window.location.href='<c:url value="contactTourOperator.html"/>'"/></td>
	</tr>
</table>

<h3>Tour Description:</h3>
<h4><c:out value="${tour.tourDesc}" /></h4>
<!--
<p>The best framed views of Lake Wakatipu can be experienced on an interpretive guided tour using flying foxes as low impact adventure access. 
Join us on a series of lines that traverse the forest in a way that will never be forgotten. 
This tour is perfect for families, groups and those who have never ziplined before.
Come join us on our exhilarating zipline (flying fox) adventure above spectacular Queentown! 
Ride up the Skyline Gondola and then glide through the treetops on a series of four flying foxes. 
Your experienced Guides will deliver an interpretive tour as you "Zzziiiiiip" from tree to tree. 
Breath in some pristine mountain air as you venture on a carefully crafted journey that combines exhilaration, adventure, and ecological exploration.
</p>
-->

<script type="text/javascript" src="js/polylines.js"></script>
</body>
</html>