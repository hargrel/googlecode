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
</head>
<body>
<h2>Add Account</h2>

<!-- Form name: accountUser -->
<!-- Attribute names: userID, userType, userName, password -->

<form:form commandName="accountUser">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td><input type="hidden" name="userType" value="operator"/></td>
		<td></td>
	</tr>
	<tr>
		<td width="100" valign="top">Username:</td>
		<td><form:input path="userName" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="userName"/></div></td>
	</tr>

	<tr>
		<td valign="top">Password:</td>
		<td width="150"><form:password path="password" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="password"/></div></td>
	</tr>
	
	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Add" /></td>
	</tr>

</table>
</form:form>


</body>
</html>