<%@ include file="/WEB-INF/views/include.jsp" %>

<html>

<head>
	<title><fmt:message key="title" /></title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/navlinks.jsp" />
	<h1>Reports</h1>
	
	Billing tour operators (<a href="reports/BillingTourOperators.pdf">pdf</a>)
(<a href="reports/BillingTourOperators.csv">csv</a>)
(<a href="reports/BillingTourOperators.xls">xls</a>)<br>

Monitoring System Utilisation (<a href="reports/MonitoringSystemUtilisation.pdf">pdf</a>)
(<a href="reports/MonitoringSystemUtilisation.csv">csv</a>)
(<a href="reports/MonitoringSystemUtilisation.xls">xls</a>)<br>

Monitoring Search Criteria Utilisation (<a href="reports/MonitoringSearchCriteriaUtilisation.pdf">pdf</a>)
(<a href="reports/MonitoringSearchCriteriaUtilisation.csv">csv</a>)
(<a href="reports/MonitoringSearchCriteriaUtilisation.xls">xls</a>)<br>

Detecting abuse (<a href="reports/DetectingAbuse.pdf">pdf</a>)
(<a href="reports/DetectingAbuse.csv">csv</a>)
(<a href="reports/DetectingAbuse.xls">xls</a>)<br>
	

</body>
	
</html>