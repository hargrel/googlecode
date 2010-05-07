<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/menu.js"/>"></script>
</head>

<body>
    
<div id="menu">
    <ul class="menu">
        <li><a href="<c:url value="SAhome.html"/>"><span><img src="<c:url value="/img/Home-icon.png"/>">Home</span></a></li>
        <li><a href="<c:url value="/search.html"/>"><span><img src="<c:url value="/img/Search-icon.png"/>">Search Tour</span></a></li>
        <li><a class="sub"><span><img src="<c:url value="/img/Account-icon.png"/>">Account</span></a>
            <div><ul>
                <li><a href="<c:url value="addAccount.html"/>"><span>Add</span></a></li>
                <li><a href="<c:url value="accountList.html"/>"><span>Edit/Delete</span></a></li>
            </ul></div>
        </li>
        <li><a class="sub" href="<c:url value="maintainSearchCriteria.html"/>"><span><img src="<c:url value="/img/Search-icon.png"/>">Search Criteria</span></a>
            <div><ul>
                <li><a href="<c:url value="globalListLocation.html"/>"><span>Global list of locations</span></a></li>
                <li><a href="<c:url value="globalListActivity.html"/>"><span>Global list of activities</span></a></li>
            </ul></div>
        </li>
        <li><a href="<c:url value="manageFee.html"/>"><span><img src="<c:url value="/img/Fee1-icon.png"/>">Fee</span></a></li>
        <li><a class="sub" href="<c:url value="produceReport.html"/>"><span><img src="<c:url value="/img/Report-icon.png"/>">Report</span></a>
            <div><ul>
                <li><a href="<c:url value="billTourOperator.html"/>"><span>Billing Tour Operators</span></a></li>
                <li><a href="<c:url value="monitorSystemUtil.html"/>"><span>System Utilisation</span></a></li>
                <li><a href="<c:url value="monitorSearchCriteriaUtil.html"/>"><span>Search Criteria Utilisation</span></a></li>
                <li><a href="<c:url value="detectAbuse.html"/>"><span>Detecting Abuse</span></a></li>
            </ul></div>
        </li>
        <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_OPERATOR">   
        <li class="last"><a href="<c:url value="/j_spring_security_logout"/>"><span><img src="<c:url value="/img/Logout-icon.png"/>">Logout</span></a></li>
        <li class="log"><a><span>Logged in as <font color='blue'><sec:authentication property="principal.username" /></font></span></a></li>
        </sec:authorize>
    </ul>
</div>
</body>

</html>