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

<!-- Form name: monitorCriteria -->
<!-- Attribute names: criteria, exportFormat -->

<form:form commandName="monitorCriteria">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="120">Search criteria:</td>
		<td><form:select path="criteria">
				<form:option value="all" label="All" />
				<form:options items="${criterias}" itemValue="s1" itemLabel="s2" />
			</form:select>
		</td>
	</tr>
	
	<tr>
		<td>Export to:</td>
		<td><form:select path="exportFormat">
				<form:option value="pdf" label="PDF" />
				<form:option value="xls" label="XLS" />
				<form:option value="csv" label="CSV" />
			</form:select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="produceReport.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Export" style="margin-top:30px;"/></td>
	</tr>

</table>
</form:form>

</body>
</html>