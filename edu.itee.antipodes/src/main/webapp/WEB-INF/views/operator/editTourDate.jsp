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

<!-- Form name: editTourDate -->
<!-- Attribute names: dateID, startDate, finishDate -->

<h2>Edit Tour Date</h2>

<form:form commandName="editTourDate">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	
	<tr>
		<!-- Insert start date -->
		<td>Start date:</td>
		<td width="100"><form:input path="startDate" size="15" id="datepicker_from" title="DD/MM/YYYY" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="startDate"/></div></td>
	</tr>

	<tr>
		<!-- Insert finish date -->
		<td>Finish date:</td>
		<td><form:input path="finishDate" size="15" id="datepicker_to" title="DD/MM/YYYY" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="finishDate" /></div></td>
	</tr>

	<tr>
		<!-- Cancel or submit -->
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Edit" /></td>
	</tr>
	
</table>
</form:form>
</body>
</html>