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

<h2>Update Tour Information</h2>

<!-- Form name: updateTourInfo -->
<!-- Attribute names: tourID, tourName, tourDesc, price, image -->

<form:form commandName="updateTourInfo">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<!-- Insert tour ID -->
		<td><form:hidden path="tourID" /></td>
	</tr>
	
	<tr>
		<!-- Insert tour name -->
		<td width="500"><h4>Tour name:</h4></td>
		<td><form:input path="tourName" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="tourName"/></div></td>
	</tr>

	<tr>
		<!-- Insert tour description -->
		<td valign="top"><h4>Tour description:</h4></td>
		<td width="500"><form:textarea path="tourDesc" cssClass="tinymce" /><div class="form-error-message"><form:errors path="tourDesc"/></div></td>
	</tr>
	
	<tr>
		<!-- Insert price -->
		<td><h4>Price:</h4></td>
		<td><form:input path="price" size="5" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="price"/></div></td>
	</tr>
	
	<tr>
		<!-- Cancel or submit -->
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Add" /></td>
	</tr>
</table>
</form:form>
</body>
</html>