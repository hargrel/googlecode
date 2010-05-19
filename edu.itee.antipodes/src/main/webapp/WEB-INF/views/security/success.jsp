<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
	font-family: "Courier";
	}
</style>
</head>
<body>
	<h2><img style="margin-bottom: -10px" src="img/Success-icon.png"/>&nbsp;&nbsp;<c:out value="${errorheader}" />!</h2>
	<h3><c:out value="${errormessage}" />.</h3>
	<p class="error"><c:out value="${errordetails}" /></p>

	
</body>
</html>