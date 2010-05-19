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
<h2>Forgotten your password?</h2>
<form action='forgotPassword.html' method='POST'>

<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="100"><h4>Email:</h4></td>
		<td><input type="text" size="40" name="email" value=''/></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="Continue" name="submit"/></td>
	</tr>

</table>
</form>
</body>
</html>