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
			.success-message { font-weight: bold; color: #900; font-size: 12px; }
		</style>
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.7.2.custom.min.js"/>"></script>

</head>
<body>
<h2>Change Password
<span class="success-message"><c:out value="${successMessage}" /></span></h2>

<!-- Form name: changeNewPassword -->
<!-- Attribute names: oldPassword, newPassword, retypePassword -->

<form:form commandName="changeNewPassword">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	

	<tr>
		<td valign="top">Current Password: </td>
		<td width="200"><form:password path="oldPassword" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="oldPassword"/></div></td>
	</tr>
	<tr>
		<td valign="top">New Password: </td>
		<td width="200"><form:password path="newPassword" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="newPassword"/></div></td>
	</tr>
	<tr>
		<td valign="top">Re-type Password: </td>
		<td width="200"><form:password path="retypePassword" size="20" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="retypePassword"/></div></td>
	</tr>
	
	<tr>
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Change" style="margin-right: 50px"/></td>
	</tr>

</table>
</form:form>


</body>
</html>