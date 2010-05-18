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
<link rel="stylesheet" href="<c:url value="/js/jwysiwyg/jquery.wysiwyg.css"/>" />
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jwysiwyg/jquery.wysiwyg.js"/>"></script>
<script type="text/javascript">
  $(function()
  {
      $('#tourDesc').wysiwyg();
  });
</script>
</head>
<body>

<h2>Add Tour</h2>

<!-- Form name: addTour -->
<!-- Attribute names: tourID, tourName, tourDesc, price, image -->

<form:form commandName="addTour">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">
	<tr>
		<!-- Insert tour name -->
		<td width="140">Tour name:</td>
		<td><form:input path="tourName" size="40" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="tourName"/></div></td>
	</tr>

	<tr>
		<!-- Insert tour description -->
		<td valign="top">Tour description:</td>
		<td width="500"><form:textarea path="tourDesc" cols="70" rows="12" id="tourDesc" /><div class="form-error-message"><form:errors path="tourDesc"/></div></td>
	</tr>
	
	<tr>
		<!-- Insert currency -->
		<td>Currency:</td>
		
		<td><form:select path="currency" items="${currencyList}" /></td>
	</tr>	
	
	<tr>
		<!-- Insert price -->
		<td valign="top">Price:</td>
		<td><form:input path="price" size="5" cssErrorClass="form-error-field"/><div class="form-error-message"><form:errors path="price"/></div></td>
	</tr>
	
	<tr>
		<!-- Set on demand value -->
		<td valign="top">On Demand:</td>
		<td><form:radiobutton path="onDemand" value="1" cssErrorClass="form-error-field"/>&nbsp;&nbsp;Yes&nbsp;&nbsp;
			<form:radiobutton path="onDemand" value="0" cssErrorClass="form-error-field"/>&nbsp;&nbsp;No
			<div class="form-error-message"><form:errors path="onDemand"/></div></td>
	</tr>
	<tr>
		<!-- Cancel or submit -->
		<td colspan="2" align="right"><input type="button" value="Cancel" onClick="window.location.href='<c:url value="TOhome.html"/>'" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Next" /></td>
	</tr>
</table>
</form:form>

</table>
</body>
</html>