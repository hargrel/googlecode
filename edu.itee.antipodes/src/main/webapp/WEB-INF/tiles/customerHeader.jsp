<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div id="header"> 
<div id="login">
<a href="<c:url value="TOlogin.html"/>" ></a>
</div>
</div>

</body>
</html>