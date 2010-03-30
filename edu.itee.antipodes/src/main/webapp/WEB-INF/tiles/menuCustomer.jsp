<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div id="tab">
    <ul>
  		<li><a class="static" href="<c:url value="search.html"/>" ><span><img src="img/Home-icon.png">Home</span></a></li>	
      	<li><a class="static" href="<c:url value="search.html"/>" ><span><img src="img/Search-icon.png">Search</span></a></li>
        <li><a class="static" href="<c:url value="tourInfo.html"/>" ><span><img src="img/Tour-icon.png">Tour Info</span></a></li>
    </ul>
    </div>
</body>
</html>