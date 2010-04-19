<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="js/maintainLink.js"></script>
</head>

<body onload="initialize()" onunload="GUnload()">
<h2>Maintain Location Link</h2>

<!-- Form name: maintain_link -->
<!-- Attribute names: locationID, locationName, latitude, langitude -->

<!-- <form name="maintain_link" action="annoformaddexample.html" method="post"> -->
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr><td><input type="hidden" name="locationID" /></td></tr>
	
	<tr>
		<td width="150"><h4>Location Name:</h4></td>
		<td><h4><c:out value="${location.locationName}" /></h4></td>
	</tr>
	<form name="frm" onsubmit="showAddress(this.address.value); return false">
	<tr>
		<td><h4>Find Location:</h4></td> 
		<td><input type="text" size="60" name="address" value="">&nbsp;&nbsp;<input type="submit" value="Find">
	</form>
	<tr>
		<td></td>
		<td><div id="map" style="width: 500px; height: 300px; margin:10px 0"></div></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="maintainSearchCriteria.html"/>'" /></td>
	</tr>


</table>
<!-- </form>-->


</body>
</html>