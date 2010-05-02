<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome, <sec:authentication property="principal.username"/></h2>

<h3>Now you can perform these operations:</h3>
<a class="home" href="<c:url value="editCompanyInfo.html"/>" >Edit company information</a><br/>
<a class="home" href="<c:url value="addTour.html"/>" >Add tour</a><br/>
<a class="home" href="<c:url value="alignTourList.html"/>" >Align tour</a><br/>
<a class="home" href="<c:url value="tourList.html"/>" >Edit/Delete tour</a><br/>
</body>
</html>