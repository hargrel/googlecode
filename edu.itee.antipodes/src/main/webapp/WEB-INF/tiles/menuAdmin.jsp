<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<body>
<div id="tab">
    <ul>
  		<li><a class="static" href="<c:url value="SAhome.html"/>"><span><img src="img/Home-icon.png">Home</span></a></li>	
      	<li><a class="static" href="<c:url value="addAccount.html"/>"><span><img src="img/Account-icon.png">Account</span></a></li>
        <li><a class="static" href="<c:url value="deleteAccount.html"/>"><span><img src="img/Search-icon.png">Search Criteria</span></a></li>
        <li><a class="static" href="<c:url value="editAccount.html"/>"><span><img src="img/Fee1-icon.png">Fee</span></a></li>
        <li><a class="static" href="<c:url value="maintainSearchCriteria.html"/>"><span><img src="img/Report-icon.png">Report</span></a></li>  
    	<li><a class="static" href="<c:url value="search.html"/>"><span><img src="img/Logout-icon.png">Logout</span></a></li>
    </ul>
    </div>
</body>

</html>