<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.form-error-field {
	background-color: #FFC;
}

.form-error-message {
	font-weight: bold;
	color: #900;
	font-size: 10px;
}
</style>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/maintainLink.js"/>"></script>
</head>
<body onload="initialize()" onunload="GUnload()">

<h2>Add Location</h2>

<!-- Form name: location -->
<!-- Attribute names: locationID, locationName, latitude, longitude -->

<form:form commandName="location">
	<table border="0" cellspacing="2"
		style="border-collapse: collapse; padding: 5px">
		<tr>
			<td width="150" valign="top">Location Name:</td>
			<td width="150"><form:input path="locationName" size="20"
				cssErrorClass="form-error-field" />&nbsp;&nbsp;<input type="button" value="Search" onclick="showAddress(document.forms['loc'].locationName.value); return false">
			<div class="form-error-message"><form:errors
				path="locationName" /></div>
			</td>
		</tr>
		
		
		<tr>
			<td width="150" valign="top">Latitude:</td>
			<td width="150"><form:input path="latitude" size="20"
				cssErrorClass="form-error-field" />
			<div class="form-error-message"><form:errors
				path="latitude" /></div>
			</td>
		</tr>
		
		<tr>
			<td width="150" valign="top">Longitude:</td>
			<td width="150"><form:input path="longitude" size="20"
				cssErrorClass="form-error-field" />
			<div class="form-error-message"><form:errors
				path="longitude" /></div>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td><div id="map" style="width: 400px; height: 250px; margin:10px 0"></div></td>
		</tr>

		<tr>
			<td colspan="2" align="right"><input type="button"
				value="Cancel"
				onClick="window.location.href='<c:url value="alignTour.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input 
				type="submit" value="Add" />
				
				</td>
		</tr>

	</table>
</form:form>

</body>
</html>