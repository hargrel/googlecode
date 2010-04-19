<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<body>
<div id="header"> 

<sec:authorize ifAllGranted="ROLE_ANONYMOUS">
<div id="login">
<a href="TOhome.html" ></a>
</div>
</sec:authorize>

<sec:authorize ifAllGranted="ROLE_OPERATOR">
<div id="TO">
<a href="TOhome.html" ></a>
</div>
</sec:authorize>

<sec:authorize ifAllGranted="ROLE_ADMIN">
<div id="Admin">
<a href="SAhome.html" ></a>
</div>
</sec:authorize>

</div>

</body>

</html>