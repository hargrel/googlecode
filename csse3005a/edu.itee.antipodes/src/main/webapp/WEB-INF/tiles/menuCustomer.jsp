<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
</head>

<body>
<div id="menu">
    <ul class="menu">
        <li><a href="<c:url value="/search.html"/>"><span><img src="<c:url value="/img/Home-icon.png"/>">Home</span></a></li>
        <li><a href="<c:url value="/browseTours.html"/>"><span><img src="<c:url value="/img/Search-icon.png"/>">Browse Tours</span></a></li>
        <li><a href="<c:url value="/aboutUs.html"/>"><span><img src="<c:url value="/img/About-icon.png"/>">About Us</span></a></li>
        <li><a href="<c:url value="/contactUs.html"/>"><span><img src="<c:url value="/img/Contact-icon.png"/>">Contact Us</span></a></li>
        <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_OPERATOR">   
        <li class="last"><a href="<c:url value="/j_spring_security_logout"/>"><span><img src="<c:url value="/img/Logout-icon.png"/>">Logout</span></a></li>
        <li class="log"><a><span>Logged in as <font color='blue'><sec:authentication property="principal.username" /></font></span></a></li>
        </sec:authorize>
    </ul>
</div>
</body>

</html>