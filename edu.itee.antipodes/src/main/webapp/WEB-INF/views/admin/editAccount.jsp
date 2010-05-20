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
			.success-message { font-weight: bold; color: #900; font-size: 12px; }
		</style>
<link type="text/css" href="<c:url value="/css/smoothness/jquery-ui-1.7.2.custom.css"/>" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.7.2.custom.min.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$('#datepicker').datepicker({
			changeMonth: true,
			changeYear: true,
			minDate:0
		});
	});
	</script>
</head>
<body>
<h2>Edit Account
<span class="success-message"><c:out value="${successMessage}" /></span></h2>

<!-- Form name: accountUser -->
<!-- Attribute names: userID, userType, userName, password -->

<form:form commandName="accountUser">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="150" valign="top">User type:</td>
		<td><form:hidden path="userType"/>
			<c:out value="${accountUser.userType}"/>
			<div class="form-error-message"><form:errors path="userType"/></div></td>
	</tr>
	
	<tr>
		<td>Username:</td>
		<td><form:input path="userName" size="20"/></div></td>
	</tr>

	<tr>
		<td valign="top">Password:</td>
		<td width="200"><form:password path="password" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="password"/></div></td>
	</tr>

	<tr style="display: <c:out value="${hide}"/>">
		<td valign="top">Membership Expiry:</td>
		<td><input name="membershipExpiry" size="20" id="datepicker" value="<c:out value="${membershipExpiry}"/>"/></td>
	</tr>
	
	<tr>
		<td colspan="2" align="right"><input type="button" value="Back" onClick="window.location.href='<c:url value="accountList.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Edit" style="margin-right: 50px"/></td>
	</tr>

</table>
</form:form>


</body>
</html>