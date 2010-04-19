<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="js/editor.js"></script>
</head>
<body>

<!-- Form name: update_companyInfo -->
<!-- Attribute names: operatorID, operatorName, companyDesc, address, postcode, state, country, telephone -->

<h2>Update Company Information</h2>

<form name="update_companyInfo" action="annoformaddexample.html" method="post">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td><input type="hidden" name="operatorID" /></td>
	</tr>
	
	<tr>
		<td width="500"><h4>Company name:</h4></td>
		<td><input type="text" size="40" name="operatorName" value="${TourOperator.operatorID}"/></td>
	</tr>

	<tr>
		<td valign="top"><h4>Company description:</h4></td>
		<td width="500"><textarea name="companyDesc" class="tinymce" value="${TourOperator.companyDesc}"></textarea></td>
	</tr>
	
	<tr>
		<td width="500"><h4>Address:</h4></td>
		<td><input type="text" size="60" name="address" value="${TourOperator.address}"/></td>
	</tr>

	<tr>
		<td width="500"><h4>Telephone:</h4></td>
		<td><input type="text" size="30" name="telephone" value="${TourOperator.telephone}"/></td>
	</tr>
	
	<tr>
		<td width="500"><h4>Email:</h4></td>
		<td><input type="text" size="30" name="email" value="${TourOperator.email}"/></td>
	</tr>		

	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Update" onclick="document['update_companyInfo'].submit()"/></td>
	</tr>
</table>
</form>
</body>
</html>