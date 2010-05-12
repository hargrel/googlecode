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
<h2>Contact Us</h2>

<!-- Form name: contactUs -->
<!-- Attribute names: name, email, telephone, subject, content -->

<form:form commandName="contactUs">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<!-- Insert name -->
		<td valign="top" width="80">Name:</td>
		<td><form:input path="name" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="name"/></div></td>
	</tr>

	<tr>
		<!-- Insert email-->
		<td valign="top">Email:</td>
		<td><form:input path="email" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="email"/></div></td>
	</tr>
	
	<tr>
		<!-- Insert subject -->
		<td valign="top">Subject:</td>
		<td><form:input path="subject" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="subject"/></div></td>
	</tr>
		
	<tr>
		<!-- Insert message -->
		<td valign="top">Message:</td>
		<td><form:textarea path="text" rows="12" cols="60" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="text"/></div></td>
	</tr>

	<tr>
		<!-- Cancel or submit -->
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="tourInfo.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" /></td></td>
	</tr>
	</table>
</form:form>

</body>
</html>