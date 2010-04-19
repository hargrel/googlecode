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
<a class="home" href="<c:url value="addAccount.html"/>" >Add account</a><br/>
<a class="home" href="<c:url value="deleteAccount.html"/>" >Delete account</a><br/>
<a class="home" href="<c:url value="editAccountList.html"/>" >Edit account list</a><br/>
<a class="home" href="<c:url value="editAccount.html"/>" >Edit account</a><br/>
<a class="home" href="<c:url value="maintainSearchCriteria.html"/>" >Maintain search criteria</a><br/>
<a class="home" href="<c:url value="manageFee.html"/>" >Manage fee</a><br/>
<a class="home" href="<c:url value="produceReport.html"/>" >Produce reports</a><br/>

</body>
</html>