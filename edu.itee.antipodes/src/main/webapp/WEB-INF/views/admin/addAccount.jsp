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
<h2>Add Account</h2>

<!-- Form name: add_account -->
<!-- Attribute names: userID, userType, userName, password -->

<form name="add_account" action="annoformaddexample.html" method="post">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td><input type="hidden" name="userID" /></td>
		<td><input type="hidden" name="userType" value="TO" /></td>
	</tr>
	
	<tr>
		<td width="150"><h4>Username:</h4></td>
		<td><input type="text" size="30" name="userName" /></td>
	</tr>

	<tr>
		<td><h4>Password:</h4></td>
		<td width="150"><input type="password" size="30" name="password" /></td>
	</tr>
	
	<tr>
		<td><h4>Re-type password:</h4></td>
		<td width="150"><input type="password" size="30" name="password" /></td>
	</tr>

	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Add" onclick="document['add_account'].submit()" /></td>
	</tr>

</table>
</form>


</body>
</html>