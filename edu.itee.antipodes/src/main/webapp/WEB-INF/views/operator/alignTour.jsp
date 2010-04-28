<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<style>
			.form-error-field { background-color: #FFC; }
			.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
		</style>
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker_from,#datepicker_to").datepicker({onSelect: restrictDates, changeMonth: true, changeYear: true});
		
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
</head>
<body>

<!-- Form name: alignTour -->
<!-- Attribute names: tourID, tourName, startDate, finishDate, totalDays, locationName, activityName -->

<h2>Align Tour Information</h2>

<form:form commandName="alignTour">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<!-- Insert tour ID -->
		<td><form:hidden path="tourID" /></td>
	</tr>
	
	<tr>
		<!-- Display tour name -->
		<td width="200"><h4>Tour name:</h4></td>
		<td><h4><c:out value="${tour.tourName}" /></h4></td>
	</tr>
	
	<tr>
		<!-- Insert starting date -->
		<td><h4>Starting date:</h4></td>
		<td width="100"><form:input path="startDate" size="15" id="datepicker_from" title="DD/MM/YYYY" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="startDate"/></div></td>
	</tr>

	<tr>
		<!-- Insert finishing date -->
		<td><h4>Finishing date:</h4></td>
		<td><form:input path="finishDate" size="15" id="datepicker_to" title="DD/MM/YYYY" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="finishDate" /></div></td>
	</tr>

	<tr>
		<!-- Insert duration -->
		<td><h4>Duration:</h4></td>
		<td><form:input path="totalDays" size="3" cssErrorClass="form-error-field"/>&nbsp;<span style="font-size: 10px; color: black;">day(s)</span><div class="form-error-message"><form:errors path="totalDays"/></div></td>
	</tr>
	
	<tr>
		<!-- Choose location from drop-down list -->
		<td><h4>Choose location:</h4></td>
		<td><form:select path="locationName">
			<form:option value="" label="Location 1" />
			<form:option value="" label="Location 2" />
			</form:select>
		</td>
			
		<!-- Add new location to the global list -->
		<td width="180"><h4>or &nbsp;&nbsp;&nbsp;&nbsp;Specify location:</h4></td>
		<td width="100"><form:input path="locationName" size="30" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="locationName"/></div></td>
		
	</tr>	
	
	<tr>
		<!-- Choose activity from drop-down list -->
		<td><h4>Choose activity:</h4></td>
		<td><form:select path="activityName">
			<form:option value="" label="Activity 1" />
			<form:option value="" label="Activity 2" />
			</form:select>
		</td>
		
		<!-- Add new activity to the global list -->
		<td><h4>or &nbsp;&nbsp;&nbsp;&nbsp;Specify activity:</h4></td>
		<td><form:input path="activityName" size="30" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="activityName"/></div></td>
	</tr>

	<tr>
		<!-- Cancel or submit -->
		<td colspan="4" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Align" /></td>
	</tr>
	
</table>
</form:form>
</body>
</html>