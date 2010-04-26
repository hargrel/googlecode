<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
</head>

<body>

<div id="menu">
    <ul class="menu">
        <li><a href="<c:url value="TOhome.html"/>"><span><img src="img/Home-icon.png">Home</span></a></li>
        <li><a href="<c:url value="search.html"/>"><span><img src="img/Search-icon.png">Search Tour</span></a></li>
        <li><a class="sub" href="#"><span><img src="img/Add-icon.png">Add</span></a>
            <div><ul>
                <li><a href="<c:url value="addCompanyInfo.html"/>"><span>Company information</span></a></li>
                <li><a href="<c:url value="addTourInfo.html"/>"><span>Tour information</span></a></li>
            </ul></div>
        </li>
        <li><a href="<c:url value="alignTour.html"/>"><span><img src="img/Align-icon.png">Align</span></a></li>
        <li><a class="sub" href="#"><span><img src="img/Update-icon.png">Update</span></a>
            <div><ul>
                <li><a href="<c:url value="updateCompanyInfo.html"/>"><span>Company information</span></a></li>
                <li><a href="<c:url value="updateTourInfoList.html"/>"><span>Tour information</span></a></li>
            </ul></div>
        </li>
        <li><a href="<c:url value="deleteTour.html"/>"><span><img src="img/Delete-icon.png">Delete</span></a></li>
        <li class="last"><a href="j_spring_security_logout"><span><img src="img/Logout-icon.png">Logout</span></a></li>
    </ul>
</div>

</body>

</html>