<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
</head>

<body>
<div id="header"> 

<sec:authorize ifAllGranted="ROLE_ANONYMOUS">
<div id="login">
<a href="login.html" ></a>
</div>
</sec:authorize>

<sec:authorize ifAllGranted="ROLE_OPERATOR">
<div id="TO">
<a href="<c:url value="/operator/TOhome.html"/>" ></a>
</div>
</sec:authorize>

<sec:authorize ifAllGranted="ROLE_ADMIN">
<div id="Admin">
<a href="<c:url value="/admin/SAhome.html"/>" ></a>
</div>
</sec:authorize>

</div>

</body>

</html>
