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
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="js/editor.js"></script>
</head>
<body>

<h2>Add Company Information</h2>

<!-- Form name: addCompanyInfo -->
<!-- Attribute names: operatorID, operatorName, companyDesc, address, telephone, email -->

<form:form commandName="addCompanyInfo">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<!-- Insert operator ID -->
		<td><form:hidden path="operatorID" /></td>
	</tr>
	
	<tr>
		<!-- Insert company name -->
		<td width="500"><h4>Company name:</h4></td>
		<td><form:input path="operatorName" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="operatorName"/></div></td>
	</tr>

	<tr>
		<!-- Insert company description -->
		<td valign="top"><h4>Company description:</h4></td>
		<td width="500"><form:textarea path="companyDesc" cssClass="tinymce" /><div class="form-error-message"><form:errors path="companyDesc"/></div></td>
	</tr>
	
	<tr>
		<!-- Insert address -->
		<td><h4>Address:</h4></td>
		<td><form:input path="address" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="address"/></div></td>
	</tr>

	<tr>
		<!-- Insert telephone -->
		<td><h4>Telephone:</h4></td>
		<td><form:input path="telephone" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="telephone"/></div></td>
	</tr>
	
	<tr>
		<!-- Insert email -->
		<td><h4>Email:</h4></td>
		<td><form:input path="email" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="email"/></div></td>
	</tr>		

	<tr>
		<!-- Cancel or submit -->
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Add"/></td>
	</tr>
</table>
</form:form>
</body>
</html>