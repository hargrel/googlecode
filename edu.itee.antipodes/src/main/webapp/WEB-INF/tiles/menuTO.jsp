<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<body>
<div id="tab">
    <ul>
  		<li><a class="static" href="<c:url value="TOhome.html"/>"><span><img src="img/Home-icon.png">Home</span></a></li>	
      	<li><a class="static" href="<c:url value="addCompanyInfo.html"/>"><span><img src="img/Add-icon.png">Add</span></a></li>
        <li><a class="static" href="<c:url value="alignTour.html"/>"><span><img src="img/Align-icon.png">Align</span></a></li>
        <li><a class="static" href="<c:url value="updateTourInfo.html"/>"><span><img src="img/Update-icon.png">Update</span></a></li>
        <li><a class="static" href="<c:url value="deleteTour.html"/>"><span><img src="img/Delete-icon.png">Delete</span></a></li>	  
    	<li><a class="static" href="<c:url value="search.html"/>"><span><img src="img/Logout-icon.png">Logout</span></a></li>
    </ul>
</div>
</body>

</html>