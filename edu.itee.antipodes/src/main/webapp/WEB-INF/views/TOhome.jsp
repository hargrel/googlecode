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

<h2>Welcome, [TourOperatorName]</h2>

<h3>Now you can perform these operations:</h3>
<a class="home" href="<c:url value="addCompanyInfo.html"/>" >Add company information</a><br/>
<a class="home" href="<c:url value="addTourInfo.html"/>" >Add tour information</a><br/>
<a class="home" href="<c:url value="alignTour.html"/>" >Align tours with search criteria</a><br/>
<a class="home" href="<c:url value="updateCompanyInfo.html"/>" >Update company information</a><br/>
<a class="home" href="<c:url value="updateTourInfo.html"/>" >Update tour information</a><br/>
<a class="home" href="<c:url value="deleteTour.html"/>" >Delete tour information</a>

</body>
</html>