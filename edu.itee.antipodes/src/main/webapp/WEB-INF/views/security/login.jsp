<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.f.j_username.focus();'>
<h2>Login</h2>
<form name='f' action='j_spring_security_check' method='POST'>

<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="100"><h4>Username:</h4></td>
		<td colspan="2"><input type="text" size="45" name="j_username" value=''/></td>
	</tr>

	<tr>
		<td><h4>Password:</h4></td>
		<td colspan="2" width="250"><input type="password" size="45" name="j_password" /></td>
	</tr>
	
	<tr>
		<td></td>
		<td style="font-size:8pt"><input type="checkbox" size="30" name="_spring_security_remember_me" />&nbsp;&nbsp;Keep me logged in</td>
		<td style="font-size:8pt" align="right"><a href="<c:url value="/forgotPassword.html"/>" style="color:blue">Forgotten your password?</a></td>
	</tr>

	<tr>
		<td colspan="3" align="right"><input type="submit" value="Login" name="submit"/></td>
	</tr>

</table>
</form>
</body>
</html>