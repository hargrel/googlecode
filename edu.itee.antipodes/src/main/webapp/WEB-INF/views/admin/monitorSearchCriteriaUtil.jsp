<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Monitoring Search Criteria Utilisation Report</h2>

<!-- Form name: monitor_criteria -->
<!-- Attribute names: criteria, fileType -->


<form name="monitor_criteria" action="(?).html" method="post">

<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="120">Search criteria:</td>
		<td><select name="criteria">
				<option value="all">All</option>
				<option value="criteria 1">Criteria 1</option>
				<option value="criteria 2">Criteria 2</option>
			</select></td>
	</tr>
	
	<tr>
		<td>Export to:</td>
		<td><select name="fileType">
				<option value="pdf">PDF</option>
				<option value="xls">XLS</option>
				<option value="csv">CSV</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="produceReport.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Export" onclick="document['monitor_criteria'].submit()" style="margin-top:30px;"/></td>
	</tr>

</table>
</form>

</body>
</html>