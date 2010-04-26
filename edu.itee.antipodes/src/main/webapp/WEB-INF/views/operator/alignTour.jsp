<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<body>

<!-- Form name: align_tour -->
<!-- Attribute names: tourID, tourName, startDate, finishDate, totalDays, locationName, activityName -->

<h2>Align Tour Information</h2>

<form name="align_tour" action="annoformaddexample.html" method="post">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td><input type="hidden" name="tourID" /></td>
	</tr>
	
	<tr>
		<td width="200"><h4>Tour name:</h4></td>
		<td><h4><c:out value="${tour.tourName}" /></h4></td>
	</tr>
	
	<tr>
		<td><h4>Starting date:</h4></td>
		<td width="100"><input type="text" size="15" id="datepicker1" name="startDate" value="DD/MM/YYYY"/></td>
	</tr>

	<tr>
		<td><h4>Finishing date:</h4></td>
		<td><input type="text" size="15" id="datepicker2" name="finishDate" value="DD/MM/YYYY"/></td>
	</tr>

	<tr>
		<td><h4>Duration:</h4></td>
		<td><input type="text" size="10" name="totalDays" />&nbsp;<span style="font-size: 10px; color: black;">day(s)</span></td>
	</tr>
	
	<tr>
		<!-- Choose location from drop-down list -->
		<td><h4>Choose location:</h4></td>
		<td><select name="locationName"><option>test 1</option>
			<option>test 2</option></select></td>
			
		<!-- Add new location to the global list -->
		<td width="180"><h4>or &nbsp;&nbsp;&nbsp;&nbsp;Specify location:</h4></td>
		<td width="100"><input type="text" size="30" name="locationName" /></td>
		
	</tr>	
	
	<tr>
		<!-- Choose activity from drop-down list -->
		<td><h4>Choose activity:</h4></td>
		<td><select name="activityName"><option>test 1</option>
			<option>test 2</option></select></td>
		
		<!-- Add new activity to the global list -->
		<td><h4>or &nbsp;&nbsp;&nbsp;&nbsp;Specify activity:</h4></td>
		<td><input type="text" size="30" name="activityName" /></td>
	</tr>

	<tr>
		<td colspan="4" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Align" onclick="document['align_tour'].submit()"/></td>
	</tr>
	
</table>
</form>
</body>
</html>