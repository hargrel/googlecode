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
<link type="text/css" href="<c:url value="/css/smoothness/jquery-ui-1.7.2.custom.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/css/jquery.multiselect.css"/>" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.7.2.custom.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.multiselect.min.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker_from,#datepicker_to").datepicker({minDate:0,
			onSelect: restrictDates, changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy'});
		
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
<script type="text/javascript">
	$(function() {
		$("#loc,#act").multiSelect({ 
			minWidth:200,
			maxHeight:90,
			selectedList:5,
			showHeader:false
		});
				
	});
</script>
</head>
<body>

<!-- Form name: alignTour -->
<!-- Attribute names: tourID, tourName, startDate, finishDate, totalDays, locationName, activityName -->

<h2>Align Tour</h2>

<form:form commandName="alignTour">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	
	<tr>
		<!-- Display tour name -->
		<td width="120">Tour name:</td>
		<td><h4><c:out value="${tour.tourName}" />
		</h4></td>
	</tr>
	
	<tr>
		<!-- Insert start & finish date -->
		<c:if test="${tour.onDemand == '0'}">
		<td colspan="2">Start date:&nbsp;&nbsp;<input name="startDate" size="10" id="datepicker_from"/>&nbsp;&nbsp;
		Finish date:&nbsp;&nbsp;<input name="finishDate" size="10" id="datepicker_to"/></td>
		
		<!-- Add new date -->
		<td><a class="home" href="<c:url value="addTourDate.html"/>">Add new date</a><br/></td>
		</c:if>
		<c:if test="${tour.onDemand == '1'}">
		<input name="startDate" type="hidden" size="10" value="00/00/0000"/>
		<input name="finishDate" type="hidden" size="10" value="00/00/0000"/>
		</c:if>
	</tr>

	<tr>
		<!-- Insert duration -->
		<c:if test="${tour.onDemand == '1'}">
		<td>Duration:</td>
		<td><form:input path="totalDays" size="3" cssErrorClass="form-error-field"/>&nbsp;<span style="font-size: 10px; color: black;">day(s)</span><div class="form-error-message"><form:errors path="totalDays"/></div></td>
		</c:if>
	</tr>
	
	<tr>
		<!-- Choose location from drop-down list -->
		<td valign="top">Choose location:</td>
		<td width="240"><form:select path="locationID" id="loc" multiple="multiple" size="3">
				<form:options items="${locations}" itemValue="locationID" itemLabel="locationName" />
			</form:select>
			<div class="form-error-message"><form:errors path="locationID"/></div>
		</td>
			
		<!-- Add new location to the global list -->
		<td><a class="home" href="<c:url value="addTourLocation.html"/>" >Add new location</a><br/></td>
		
	</tr>	
	
	<tr>
		<!-- Choose activity from drop-down list -->
		<td>Choose activity:</td>
		<td><form:select path="activityID" id="act" multiple="multiple" size="3">
				<form:options items="${activities}" itemValue="activityID" itemLabel="activityName" />
			</form:select>
			<div class="form-error-message"><form:errors path="activityID"/></div>
		</td>
		
		<!-- Add new activity to the global list -->
		<td><a class="home" href="<c:url value="addTourActivity.html"/>" >Add new activity</a><br/></td>
	</tr>

	<tr>
		<!-- Cancel or submit -->
		<td colspan="3" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Align" /></td>
	</tr>
	
</table>
</form:form>
</body>
</html>