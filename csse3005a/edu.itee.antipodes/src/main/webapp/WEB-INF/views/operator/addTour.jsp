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
<link rel="stylesheet"
	href="<c:url value="/js/jwysiwyg/jquery.wysiwyg.css"/>" />
<script type="text/javascript"
	src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/jwysiwyg/jquery.wysiwyg.js"/>"></script>
<script type="text/javascript">
  $(function()
  {
      $('#tourDesc').wysiwyg();
  });
</script>
<script type="text/javascript">
function dispText() {
	document.getElementById("hide").style.display = '';
}
function hideText() {
	document.getElementById("hide").style.display = 'none';
}
</script>
<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAQlV1b2FPUM74rst4A4cFzxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxQSgLSOP2XkswKd7txk3wHZjh27CA&sensor=false"
	type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/gmap/routes.js"/>"></script>
</head>
<body onload="createMap()" onunload="GUnload()">

<h2>Add Tour</h2>

<!-- Form name: addTour -->
<!-- Attribute names: tourID, tourName, tourDesc, price, image -->

<form:form commandName="addTour">
	<table border="0" cellspacing="2"
		style="border-collapse: collapse; padding: 5px">
		<tr>
			<!-- Insert tour name -->
			<td width="140">Tour name:</td>
			<td><form:input path="tourName" size="40"
				cssErrorClass="form-error-field" />
			<div class="form-error-message"><form:errors path="tourName" /></div>
			</td>
		</tr>

		<tr>
			<!-- Insert tour description -->
			<td valign="top">Tour description:</td>
			<td width="500"><form:textarea path="tourDesc"
				cssStyle="width:500px" id="tourDesc" />
			<div class="form-error-message"><form:errors path="tourDesc" /></div>
			</td>
		</tr>

		<tr>
			<!-- Insert currency -->
			<td>Currency:</td>
			<td><form:select path="currency" items="${currencyList}" /></td>
		</tr>

		<tr>
			<!-- Insert price -->
			<td valign="top">Price:</td>
			<td><form:input path="price" size="5"
				cssErrorClass="form-error-field" />
			<div class="form-error-message"><form:errors path="price" /></div>
			</td>
		</tr>

		<tr>
			<!-- Set on demand value -->
			<td valign="top">On demand:</td>
			<td><form:radiobutton path="onDemand" value="1"
				cssErrorClass="form-error-field" />&nbsp;&nbsp;Yes&nbsp;&nbsp; <form:radiobutton
				path="onDemand" value="0" cssErrorClass="form-error-field" />&nbsp;&nbsp;No
			<div class="form-error-message"><form:errors path="onDemand" /></div>
			</td>
		</tr>

		<tr>
			<!-- Set tour route -->
			<td valign="top" rowspan="3">Tour routes:</td>
			<td><input type="text" id="locationName" size="20" />&nbsp;&nbsp;<input
				type="button" value="Search" onclick="centerMap()"></td>
		</tr>

		<tr>
			<td>
			<div id="map_canvas"
				style="width: 510px; overflow: hidden; height: 250px; margin: 10px 0 0 0"></div>
			<input id="txtLevel" type="hidden" size=3 value="3" /> <input
				id="latitude" type="hidden" /> <input id="longitude" type="hidden" />
			<form:hidden path="points" /> <form:hidden path="levels" /></td>
		</tr>

		<tr>
			<td><input type="button" value="Add Point" onclick="addPoint()" />&nbsp;&nbsp;<input
				type="button" value="Delete Selected Point" onclick="deletePoint()" />&nbsp;&nbsp;<input
				type="button" value="Delete All Points" onclick="deleteAllPoints()" /></td>
		</tr>
		
		<tr>
			<td><a style="color:blue" href="userManual.html#Add"><img src="<c:url value="/img/Help-icon.png"/>" style="margin-right:10px;margin-bottom:-2px">Help</a></td>
		</tr>

		<tr id="hide" style="display: none">
			<td><select id="pointList" size="8"
				onchange="highlight(this.selectedIndex)" ondblclick="jumpToPoint()"></select></td>
		</tr>

		<tr>
			<!-- Cancel or submit -->
			<td colspan="2" align="right"><input type="button"
				value="Cancel"
				onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" value="Next" style="margin-top: 30px" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>