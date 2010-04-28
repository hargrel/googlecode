<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<h2>Billing Tour Operators Report</h2>

<!-- Form name: bill_operator -->
<!-- Attribute names: fromDate, toDate, tourOperator, fileType -->


<form:form commandName="billingTourOperator">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td rowspan="2" valign="top" width="100"><h4>Name:</h4></td>
		<td><form:input path="toDate" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="toDate"/></div></td></tr>

	
	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="tourInfo.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" /></td>
	</tr>
	</table>
</form:form>



<form name="bill_operator" action="reports/BillingTourOperators" method="post">

<table border="0" width=100% style="border-collapse:collapse; margin-right:30px">

	<tr>
		<td width="175">From:&nbsp;&nbsp;<input type="text" size="15" id="datepicker1" value="DD/MM/YYYY" name="fromDate"/></td>
		<td>To:&nbsp;&nbsp;<input type="text" size="15" id="datepicker2" value="DD/MM/YYYY" name="toDate"/></td>
	</tr>
	
	<tr>
		<td colspan="2">Tour Operator:&nbsp;&nbsp;
			<select name="tourOperator">
				<c:forEach items="${touroperators}" var="to">
					<option value="${to.operatorID}"><c:out value="${to.operatorName}" /></option>
				</c:forEach>
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