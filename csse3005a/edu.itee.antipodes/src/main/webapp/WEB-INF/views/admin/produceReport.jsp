<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Reports</h2>

<a class="home" href="<c:url value="billTourOperator.html"/>" >Billing tour operators</a><br/>
<a class="home" href="<c:url value="monitorSystemUtil.html"/>" >Monitoring System Utilisation</a><br/>
<a class="home" href="<c:url value="monitorSearchCriteriaUtil.html"/>" >Monitoring Search Criteria Utilisation</a><br/>
<a class="home" href="<c:url value="detectAbuse.html"/>" >Detecting abuse</a><br/>

</body>
</html>