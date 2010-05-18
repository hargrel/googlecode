<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="<c:url value="/css/jquery.multiselect.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/css/smoothness/jquery-ui-1.7.2.custom.css"/>" rel="stylesheet" />
		<style>
			.form-error-field { background-color: #FFC; }
			.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
		</style>
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
		$("#act").multiSelect({ 
			minWidth:300,
			maxHeight:90,
			selectedList:5,
			noneSelectedText: "Select activities",
			showHeader:false
		});
				
	});
</script>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/gmap/search.js"/>"></script>
</head>

<body onload="initialize()" onunload="GUnload()">

<h2>Search Tours</h2>

<!-- Form name: search -->
<!-- Attribute names: locationName, activityName, startDate, endDate, currency -->


<form:form commandName="search">

<table border="0" width=640 style="border-collapse:collapse; margin-right:30px">
	<tr>
		<!-- Location -->
		<td rowspan="3" valign="top" width=25%>Locations:</td>
		<td><span style="font-size: 9px; color: #333;">Choose locations, using comma to separate</span></td>
	</tr>
	
	<tr>
		
		<td><form:input path="locationName" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="locationName"/></div></td>
	</tr>
	
	
	<tr>
		<!-- Google map -->
		<td><div id="map_canvas" style="width: 500px; height: 300px; margin:10px 0; overflow: hidden"></div></td>
	</tr>
					
	<tr>
		<!-- Activity -->
		<td rowspan="2" valign="top">Activities:</td>
		<td valign="bottom"><span style="font-size: 9px; color: #333;">Choose activities, using comma to separate</span></td>
	</tr>
	
	<tr>
		<td><!--<form:input path="activityName" size="40" cssErrorClass="form-error-field"/>-->
		<form:select path="activityName" id="act" multiple="multiple">
				<form:option value="" label="Select activities"/>
				<form:options items="${activities}" itemValue="activityName" itemLabel="activityName" />
			</form:select>
		<div class="form-error-message"><form:errors path="activityName"/></div>
		</td>
	</tr>
	
	<tr>
		<!-- Start date -->
		<td valign="top">Start date:</td>
		<td><form:input path="startDate" size="15" id="datepicker_from" title="DD/MM/YYYY" cssErrorClass="form-error-field"/>&nbsp;&nbsp;<span style="font-size: 12px; font-style:italic; color: black;">(DD/MM/YYYY)<span>
		<div class="form-error-message"><form:errors path="startDate"/></div></td>
	</tr>
	
	<tr>
		<!--Finish date -->
		<td valign="top">Finish date:</td>
		<td><form:input path="finishDate" size="15" id="datepicker_to" title="DD/MM/YYYY" cssErrorClass="form-error-field"/>&nbsp;&nbsp;<span style="font-size: 12px; font-style:italic; color: black;">(DD/MM/YYYY)<span>
		<div class="form-error-message"><form:errors path="finishDate" /></div></td>
	</tr>

	<tr>
		<!-- Search -->
		<td colspan="2" align="right"><input type="submit" value="Search" /></td>
	</tr>
</table>

</form:form>
</body>
</html>