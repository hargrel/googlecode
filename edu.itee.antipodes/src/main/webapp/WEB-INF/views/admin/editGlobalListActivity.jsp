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

<h2>Edit Global List of Activities</h2>

<!-- Form name: activity -->
<!-- Attribute names: activityID, activityName -->

<form:form commandName="activity">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<td><form:hidden path="activityID" /></td>
	</tr>
	
	<tr>
		<td width="150" valign="top">Activity Name:</td>
		<td width="150"><form:input path="activityName" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="activityName"/></div></td>
	</tr>


	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="globalListActivity.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Edit" /></td>
	</tr>

</table>
</form:form>

</body>
</html>