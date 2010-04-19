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

<h2>Edit Global List of Locations</h2>

<!-- Form name: edit_location -->
<!-- Attribute names: locationID, locationName -->

<form name="edit_location" action="annoformaddexample.html" method="post">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td><input type="hidden" name="locationID" /></td>
	</tr>
	
	<tr>
		<td width="150"><h4>Location Name:</h4></td>
		<td width="150"><input type="text" size="30" name="locationName" /></td>
	</tr>


	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="editGlobalList.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Edit" onclick="document['edit_location'].submit()" /></td>
	</tr>

</table>
</form>

</body>
</html>