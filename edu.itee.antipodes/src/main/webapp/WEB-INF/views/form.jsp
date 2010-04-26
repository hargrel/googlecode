<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Contact Us</title>
		<style>
			.form-item { margin: 20px 0; }
			.form-label { font-weight: bold; }
			.form-error-field { background-color: #FFC; }
			.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
		</style>
	</head>
	<body>
	
<h2>Contact Us</h2>


<%-- Give command object a meaningful name instead of using default name, 'command' --%>

<form:form commandName="userMessage">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td rowspan="2" valign="top" width="160"><div class="form-label">Your name:</div></td>
		<td><form:input path="name" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="name"/></div></td></tr>

	<tr>
		<td rowspan="2" valign="top"><div class="form-label">Your e-mail address:</div></td>
		<td><form:input path="email" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="email"/></div></td></tr>
		
	<tr>
		<td rowspan="2" valign="top"><div class="form-label">Your message:</div></td>
		<td><form:textarea path="text" rows="12" cols="60" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="text"/></div></td></tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="Submit" /></td>
	</tr>
	</table>
</form:form>

<%--
<form name="userMessage" method="post">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="100"><h4>Name:</h4></td>
		<td><input type="text" size="40" name="name" value="" /></td>
		<td><span name="name.errors"></span></td>
	</tr>

	<tr>
		<td><h4>Email:</h4></td>
		<td><input type="text" size="40" name="email" value=""/></td>
	</tr>
	
	<tr>
		<td><h4>Message:</h4></td>
		<td colspan="2"><textarea name="text" rows="15" cols="60" value=""></textarea></td>
	</tr>

	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="tourInfo.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" onclick="document['userMessage'].submit()" /></td>
	</tr>

</table>
</form>
--%>

	</body>
</html>
