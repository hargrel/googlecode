<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.f.j_username.focus();'>
<h2>Login</h2>
<p><font color='red'>Your login attempt was not successful, try again.<br/>Reason: Bad credentials</font></p>
<form name='f' action='j_spring_security_check' method='POST'>

<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="100"><h4>Username:</h4></td>
		<td><input type="text" size="30" name="j_username" value=''/></td>
	</tr>

	<tr>
		<td><h4>Password:</h4></td>
		<td width="100"><input type="password" size="30" name="j_password" /></td>
	</tr>
	<tr>
		<td width="100"><input type="checkbox" size="30" name="_spring_security_remember_me" /></td>
		<td width="100"><h4>Remember Me</h4></td>
	</tr>
	<tr>
	
	
		<td colspan="2" align="right"><input type="submit" value="Login" name="submit"/></td>
	
	</tr>

</table>
</form>

</body>
</html>