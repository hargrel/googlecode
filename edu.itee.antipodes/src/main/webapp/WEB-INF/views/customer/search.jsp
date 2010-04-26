<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker1").datepicker();
		$("#datepicker2").datepicker();
	});
</script>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="js/search.js"></script>
</head>

<body onload="initialize()" onunload="GUnload()">

<h2>Search</h2>

<!-- Form name: search -->
<!-- Attribute names: locationName, activityName, startDate, endDate, currency -->


<form name="search" action="annoformaddexample.html" method="post">

<table border="0" width=100% style="border-collapse:collapse; margin-right:30px">
	<tr>
		<td rowspan="3" valign="top" width=30%><h3>Locations:</h3></td>
		<td><span style="font-size: 9px; color: #333;">Type locations, using comma to separate</span></td>
	</tr>
	
	<tr>
		<td><input type="text" size="40" name="locationName" /></td>
	</tr>
	
	<tr>
		<td><div id="map_canvas" style="width: 500px; height: 300px; margin:10px 0"></div></td>
	</tr>
					
	<tr>
		<td rowspan="2"><h3>Activities:</h3></td>
		<td valign="bottom"><span style="font-size: 9px; color: #333;">Type activities, using comma to separate</span></td>
	</tr>
	
	<tr>
		<td><input type="text" size="40" name="activityName" /></td>
	</tr>

	<tr>
		<td><h3>Starting date:</h3></td>
		<td><input type="text" size="15" id="datepicker1" value="DD/MM/YYYY" name="startDate"/></td>
	</tr>

	<tr>
		<td><h3>Finishing date:</h3></td>
		<td><input type="text" size="15" id="datepicker2" value="DD/MM/YYYY" name="finishDate"/></td>
	</tr>

	<tr>
		<td><h3>Currency:</h3></td>
		<td><select name="currency"><option value="AUD">AUD</option>
			<option value="USD">USD</option></select></td>
	</tr>

	<tr>
		<td colspan="2" align="right"><input type="submit" value="Search" onclick="document['search'].submit()"/></td>
	</tr>
</table>

</form>
</body>
</html>