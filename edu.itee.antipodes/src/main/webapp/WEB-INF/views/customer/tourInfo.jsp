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
<link type="text/css" href="<c:url value="/js/lightbox/jquery.fancybox-1.3.1.css"/>" rel="stylesheet" />
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/gmap/tourInfo.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/lightbox/jquery.fancybox-1.3.1.pack.js"/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("a.group").fancybox({
		'transitionIn'	:	'elastic',
		'transitionOut'	:	'elastic',
		'speedIn'		:	400, 
		'speedOut'		:	200, 
		'overlayShow'	:	false
	});
});
	</script>
</head>

<body onload="initialize()" onunload="GUnload()">
<h5><c:out value="${listedTour.tour.tourName}" /></h5>


<table border="0" align="center" width=100% style="border-collapse:collapse">
	
	<tr>
		<!-- Google Map -->
		<td rowspan="5" valign="top" width=35% ><div id="map_canvas" style="width: 600px; height: 300px; margin-right:20px"></div></td>
		
		<!-- Price -->
		<td valign="top"><b>Price:</b>&nbsp;&nbsp;<c:out value="${cur:convert(listedTour.tour.price,listedTour.tour.currency)}" /></td>
	</tr>
	
		<!-- Dates -->
	
		<tr>
			
			<td valign="top"><b>Departures:</b><select>
			<c:forEach items="${listedTour.tour.tourDates}" var="tourDate">
			<option><fmt:formatDate value=
              "${tourDate.startDate}" pattern="d MMM yyyy"/> - <fmt:formatDate value=
              "${tourDate.finishDate}" pattern="d MMM yyyy"/></option>
            </c:forEach>
            </select>
            </td>
		</tr>

	
		<!-- Tour Operator -->
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
		<td><input type="button" value="Contact Tour Operator" style="margin-top: 50px" onClick="window.location.href='<c:url value="contactTourOperator.html?operatorID=${listedTour.operator.operatorID}"/>'"/></td>
	</tr>
</table>

<div class="desc">

<!-- Location -->
<h4 style="color: #698B22">Location:</h4>
<ul>
<c:forEach items="${listedTour.tour.locations}" var="location">
<li style="display:inline">&#187;&nbsp;<c:out value="${location.locationName}" /></li>
<input type="hidden" name="latitude" id="latitude" value="<c:out value="${location.latitude}" />"></input>
<input type="hidden" name="longitude" id="longitude" value="<c:out value="${location.longitude}" />"></input>
</c:forEach>
</ul>

<!-- Activity -->
<h4>Activity:</h4>
<ul>
<c:forEach items="${listedTour.tour.activities}" var="activity">
<li style="display:inline">&#187;&nbsp;<c:out value="${activity.activityName}" />&nbsp;&nbsp;</li>
</c:forEach>
</ul>
<!-- Description -->
<h4 style="color: #228B22">Description:</h4>
<p style="width: 400px">
<c:out value="${listedTour.tour.tourDesc}" escapeXml="false"/>
</p>
<!-- Images -->
<h4>Images:</h4>
<!--
<a class="group" rel="group1" href="<c:url value="/img/test.jpg"/>"><img src="<c:url value="/img/test.jpg"/>" width="100px"/></a>
<a class="group" rel="group1" href="<c:url value="/img/002.jpg"/>"><img src="<c:url value="/img/test.jpg"/>" width="100px"/></a>
-->

<c:forEach items="${listedTour.tour.images}" var="image">
<img src="<c:url value="/uploads/images/"/><c:out value="${image.url}" />" width="200px"/>
<c:out value="${image.url}" />
</c:forEach>

<!--
<c:forEach items="${listedTour.tour.images}" var="image">
<a class="group" rel="images" href="<c:url value="/uploads/images/"/><c:out value="${image.url}" />"><img src="<c:url value="/uploads/images/"/><c:out value="${image.url}" />" width="100px"/></a>
</c:forEach>
-->
</div>
</body>
</html>