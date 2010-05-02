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

<h2>Detecting Abuse Report</h2>

<!-- Form name: detectAbuse -->
<!-- Attribute names: exportFormat -->


<form:form commandName="detectAbuse">
<table border="0" style="border-collapse:collapse; margin-right:30px">
	<tr>
		<td width="140" valign="top">Number of criteria:</td>
		<td><form:input path="criteriaNum" size="5" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="criteriaNum"/></div></td>
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