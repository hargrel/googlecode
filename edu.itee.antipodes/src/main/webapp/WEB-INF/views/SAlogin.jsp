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
<h2>Administrator Login</h2>

<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="100"><h4>Username:</h4></td>
		<td><input type="text" size="30" name="username" /></td>
	</tr>

	<tr>
		<td><h4>Password:</h4></td>
		<td width="100"><input type="password" size="30" name="password" /></td>
	</tr>

	<tr>
	
	<form>
		<td colspan="2" align="right"><input type="button" value="Login" onClick="window.location.href='<c:url value="SAhome.html"/>'"/></td>
	</form>
	</tr>

</table>


</body>
</html>