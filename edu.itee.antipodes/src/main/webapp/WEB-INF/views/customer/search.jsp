<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" />
		<style>
			.form-error-field { background-color: #FFC; }
			.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
		</style>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker_from,#datepicker_to").datepicker({minDate:0,
			onSelect: restrictDates, changeMonth: true, changeYear: true});
		
		function restrictDates(dateStr) {
		    if (this.id == 'datepicker_from') {
		        $('#datepicker_to').datepicker('option', 'minDate', $(this).datepicker('getDate'));
		    }
		    else {
		        $('#datepicker_from').datepicker('option', 'maxDate', $(this).datepicker('getDate'));
		    }
		}
				
	});
</script>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="js/search.js"></script>
</head>

<body onload="initialize()" onunload="GUnload()">

<h2>Search</h2>

<!-- Form name: search -->
<!-- Attribute names: locationName, activityName, startDate, endDate, currency -->


<form:form commandName="search">

<table border="0" width=640 style="border-collapse:collapse; margin-right:30px">
	<tr>
		<td rowspan="3" valign="top" width=25%>Locations:</td>
		<td><span style="font-size: 9px; color: #333;">Type locations, using comma to separate</span></td>
	</tr>
	
	<tr>
		<td><form:input path="locationName" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="locationName"/></div></td>
	</tr>
	
	
	<tr>
		<td><div id="map_canvas" style="width: 500px; height: 300px; margin:10px 0"></div></td>
	</tr>
					
	<tr>
		<td rowspan="2">Activities:</td>
		<td valign="bottom"><span style="font-size: 9px; color: #333;">Type activities, using comma to separate</span></td>
	</tr>
	
	<tr>
		<td><form:input path="activityName" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="activityName"/></div></td>
	</tr>
	
	<tr>
		<td valign="top">Starting date:</td>
		<td><form:input path="startDate" size="15" id="datepicker_from" title="DD/MM/YYYY" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="startDate"/></div></td>
	</tr>
	
	<tr>
		<td valign="top">Finishing date:</td>
		<td><form:input path="finishDate" size="15" id="datepicker_to" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="finishDate" /></div></td>
	</tr>

	<!-- <tr>
		<td><h3>Currency:</h3></td>
		<td><select name="currency"><option value="AUD">AUD</option>
			<option value="USD">USD</option></select></td>
	</tr> -->

	<tr>
		<td colspan="2" align="right"><input type="submit" value="Search" /></td>
	</tr>
</table>

</form:form>
</body>
</html>