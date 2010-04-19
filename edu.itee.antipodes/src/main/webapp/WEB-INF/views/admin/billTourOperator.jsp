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

<h2>Billing Tour Operators Report</h2>

<!-- Form name: bill_operator -->
<!-- Attribute names: fromDate, toDate, tourOperator, fileType -->


<form name="bill_operator" action="(?).html" method="post">

<table border="0" width=100% style="border-collapse:collapse; margin-right:30px">

	<tr>
		<td width="175">From:&nbsp;&nbsp;<input type="text" size="15" id="datepicker1" value="DD/MM/YYYY" name="fromDate"/></td>
		<td>To:&nbsp;&nbsp;<input type="text" size="15" id="datepicker2" value="DD/MM/YYYY" name="toDate"/></td>
	</tr>
	
	<tr>
		<td colspan="2">Tour Operator:&nbsp;&nbsp;<select name="tourOperator">
				<option value="Operator 1">Operator 1</option>
				<option value="Operator 2">Operator 2</option>
				<option value="Operator 3">Operator 3</option>
			</select></td>
	</tr>
	
	<tr>
		<td colspan="2">Export to:&nbsp;&nbsp;<select name="fileType">
				<option value="pdf">PDF</option>
				<option value="xls">XLS</option>
				<option value="csv">CSV</option>
			</select></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="produceReport.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Export" onclick="document['bill_operator'].submit()" style="margin-top:30px;"/></td>
	</tr>
	
</table>

</form>

</body>
</html>