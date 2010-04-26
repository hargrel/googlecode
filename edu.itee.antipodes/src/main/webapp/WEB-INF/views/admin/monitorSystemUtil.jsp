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

<h2>Monitoring System Utilisation Report</h2>

<!-- Form name: monitor_system -->
<!-- Attribute names: fromDate, toDate, fileType -->


<form name="monitor_system" action="reports/MonitoringSystemUtilisation" method="post">

<table border="0" width=100% style="border-collapse:collapse; margin-right:30px">

	<tr>
		<td width="175">From:&nbsp;&nbsp;<input type="text" size="15" id="datepicker1" value="DD/MM/YYYY" name="fromDate"/></td>
		<td>To:&nbsp;&nbsp;<input type="text" size="15" id="datepicker2" value="DD/MM/YYYY" name="toDate"/></td>
	</tr>
	
	<tr>
		<td colspan="2">Export to:&nbsp;&nbsp;<select name="fileType">
				<option value="pdf">PDF</option>
				<option value="xls">XLS</option>
				<option value="csv">CSV</option>
			</select></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="produceReport.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Export" onclick="document['monitor_system'].submit()" style="margin-top:30px;"/></td>
	</tr>
	
</table>

</form>

</body>
</html>