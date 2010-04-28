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
<h2>Manage Fees</h2>

<!-- Form name: monthlyFee -->
<!-- Attribute names: fee -->

<form:form commandName="monthlyFee">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td rowspan="2" width="100"><h4>Old fee:</h4></td>
		<td><h4><c:out value="${MonthlyFee.fee}" /></h4></td>
	</tr>
	<tr></tr>

	<tr>
		<td><h4>New fee:</h4></td>
		<td width="70"><form:input path="fee" size="10" cssErrorClass="form-error-field"/></td>
	</tr>
	<tr><td><div class="form-error-message"><form:errors path="fee"/></div></td></tr>
	

	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Change" onclick="document['manage_fee'].submit()" /></td>
	</tr>

</table>
</form:form>


</body>
</html>