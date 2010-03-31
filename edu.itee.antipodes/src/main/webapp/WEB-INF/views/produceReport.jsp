<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h4>Billing tour operators</h4>
<p>
<a href="<c:url value="reports/BillingTourOperators.pdf"/>"><img src="img/PDF-icon.png">PDF</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/BillingTourOperators.csv"/>"><img src="img/CSV-icon.png">CSV</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/BillingTourOperators.xls"/>"><img src="img/XLS-icon.png">XLS</a>
</p>

<h4>Monitoring System Utilisation</h4>
<p>
<a href="<c:url value="reports/MonitoringSystemUtilisation.pdf"/>"><img src="img/PDF-icon.png">PDF</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/MonitoringSystemUtilisation.csv"/>"><img src="img/CSV-icon.png">CSV</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/MonitoringSystemUtilisation.xls"/>"><img src="img/XLS-icon.png">XLS</a>
</p>

<h4>Monitoring Search Criteria Utilisation</h4>
<p>
<a href="<c:url value="reports/MonitoringSearchCriteriaUtilisation.pdf"/>"><img src="img/PDF-icon.png">PDF</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/MonitoringSearchCriteriaUtilisation.csv"/>"><img src="img/CSV-icon.png">CSV</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/MonitoringSearchCriteriaUtilisation.xls"/>"><img src="img/XLS-icon.png">XLS</a>
</p>

<h4>Detecting abuse</h4> 
<p>
<a href="<c:url value="reports/DetectingAbuse.pdf"/>"><img src="img/PDF-icon.png">PDF</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/DetectingAbuse.csv"/>"><img src="img/CSV-icon.png">CSV</a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value="reports/DetectingAbuse.xls"/>"><img src="img/XLS-icon.png">XLS</a>
</p>

</body>
</html>