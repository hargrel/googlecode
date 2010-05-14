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

#pointList {
      width: 255px;
      font-size: 10px;
    }
</style>
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/routes.js"/>"></script>
</head>
<body onload="createMap()" onunload="GUnload()">

<h2>Add Location</h2>

<!-- Form name: location -->
<!-- Attribute names: locationID, locationName, latitude, longitude -->

<form:form commandName="location">
	<table border="0" cellspacing="2"
		style="border-collapse: collapse; padding: 5px">
		<tr>
			<td width="150" valign="top">Location:&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="locationName" size="20"
				cssErrorClass="form-error-field" />&nbsp;&nbsp;<input type="button" value="Search" onclick="centerMap()">
			<div class="form-error-message"><form:errors
				path="locationName" /></div></td>
		</tr>
		
		
		<tr>
			<td width="150" valign="top">Latitude:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="latitude" size="20"
				cssErrorClass="form-error-field" />
			<div class="form-error-message"><form:errors
				path="latitude" /></div></td>
		</tr>
		
		<tr>
			<td width="150" valign="top">Longitude:&nbsp;&nbsp;<form:input path="longitude" size="20"
				cssErrorClass="form-error-field" />&nbsp;&nbsp;<input type="button" value="Add Point" onclick="addPoint()"/>
			<div class="form-error-message"><form:errors
				path="longitude" /></div></td>
		</tr>
		
		<tr>
			<td><input id="txtLevel" type="hidden" size=3 value="3"/></td>
		</tr>
		
		<tr>
			<td rowspan="4"><div id="map_canvas" style="width: 400px; overflow: hidden; height: 250px; margin:10px 20px 0 0"></div></td>
		</tr>
		
		<tr>
			<td>Point List</td>
		</tr>
		
		<tr>
			<td><select id="pointList" size="8" onchange="highlight(this.selectedIndex)"
  			ondblclick="jumpToPoint()"></select></td>
  		</tr>
  		
  		<tr>
 			 <td valign="top"><input type="button" value="Delete Selected Point" onclick="deletePoint()"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="Delete All Points" onclick="deleteAllPoints()"/></td>
  		</tr>
  			
		<tr>
			<td>
			<form:hidden path="points"/>
			<form:hidden path="levels"/>
			</td>
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