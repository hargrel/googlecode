<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<style>
			.form-item { margin: 20px 0; }
			.form-label { font-weight: bold; }
			.form-error-field { background-color: #FFC; }
			.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
		</style>
</head>
<body>
<h2>Contact Tour Operator</h2>

<!-- Form name: email_operator -->
<!-- Attribute names: name, email, telephone, subject, content -->
<form:form commandName="contactOperator">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td rowspan="2" valign="top" width="100"><h4>Name:</h4></td>
		<td><form:input path="name" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="name"/></div></td></tr>

	<tr>
		<td rowspan="2" valign="top"><h4>Email:</h4></td>
		<td><form:input path="email" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="email"/></div></td></tr>
	
	<tr>
		<td rowspan="2" valign="top"><h4>Telephone:</h4></td>
		<td><form:input path="telephone" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="telephone"/></div></td></tr>
	
	<tr>
		<td rowspan="2" valign="top"><h4>Subject:</h4></td>
		<td><form:input path="subject" size="40" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="subject"/></div></td></tr>
		
	<tr>
		<td rowspan="2" valign="top"><h4>Message:</h4></td>
		<td><form:textarea path="text" rows="12" cols="60" cssErrorClass="form-error-field"/></td>
	</tr>
		<tr><td><div class="form-error-message"><form:errors path="text"/></div></td></tr>
	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="tourInfo.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" /></td></td>
	</tr>
	</table>
</form:form>

<!--
<form name="email_operator" action="annoformaddexample.html" method="post">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td width="100"><h4>Name:</h4></td>
		<td><input type="text" size="40" name="name" /></td>
	</tr>

	<tr>
		<td><h4>Email:</h4></td>
		<td><input type="text" size="40" name="email" /></td>
	</tr>
	
	<tr>
		<td><h4>Telephone:</h4></td>
		<td><input type="text" size="40" name="telephone" /></td>
	</tr>
	
	<tr>
		<td><h4>Subject:</h4></td>
		<td><input type="text" size="40" name="subject" /></td>
	</tr>
	
	<tr>
		<td colspan="2"><textarea name="content" rows="15" cols="60"></textarea></td>
	</tr>

	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="tourInfo.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" onclick="document['email_operator'].submit()" /></td>
	</tr>

</table>
</form>
-->
</body>
</html>