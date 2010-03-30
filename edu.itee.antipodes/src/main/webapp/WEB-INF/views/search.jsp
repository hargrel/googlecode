<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="style.css"/>	
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker1").datepicker();
		$("#datepicker2").datepicker();
	});
</script>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="js/gmap4.js"></script>
</head>

<body onload="initialize()" onunload="GUnload()">
<h2>Search</h2>

<form method="post" name="test" commandName="search">

<table border="0" width=100% style="border-collapse:collapse; margin-right:30px">
	<tr>
		<td rowspan="3" valign="top" width=30%><h3>Locations:</h3></td>
		<td>Type locations, using comma to separate</td>
	</tr>
	
	<tr>
		<td><input type="text" size="40" name="locations" /></td>
	</tr>
	
	<tr>
		<td><div id="map_canvas" style="width: 500px; height: 300px; margin:10px 0"></div></td>
	</tr>
					
	<tr>
		<td rowspan="2"><h3>Activities:</h3></td>
		<td valign="bottom">Type activities, using comma to separate</td>
	</tr>
	
	<tr>
		<td><input type="text" size="40" name="activities" /></td>
	</tr>

	<tr>
		<td><h3>Starting date:</h3></td>
		<td><input type="text" size="15" id="datepicker1" value="DD/MM/YYYY" /></td>
	</tr>

	<tr>
		<td><h3>Finishing date:</h3></td>
		<td><input type="text" size="15" id="datepicker2" value="DD/MM/YYYY" /></td>
	</tr>

	<tr>
		<td><h3>Currency:</h3></td>
		<td><select name="finish-date"><option>AUD</option>
			<option>USD</option></select></td>
	</tr>

	<tr>
		<td colspan="2" align="right"><input type="submit" value="Search"/></td>
	</tr>
</table>

</form>
</body>
</html>