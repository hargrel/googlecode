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

<h2>Detecting Abuse Report</h2>

<p>
Export to:&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/DetectingAbuse.pdf"/>"><img src="img/PDF-icon.png">PDF</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/DetectingAbuse.csv"/>"><img src="img/CSV-icon.png">CSV</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/DetectingAbuse.xls"/>"><img src="img/XLS-icon.png">XLS</a>
</p>

<input type="button" value="Cancel" onClick="window.location.href='<c:url value="produceReport.html"/>'" style="margin-top:30px;"/>


</body>
</html>