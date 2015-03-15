<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="manual">
<a name="Top"></a>
<h2>User Manual</h2>


1.&nbsp;<a href="#Add">Adding Tour Information</a><br />

&nbsp;&nbsp;&nbsp;&nbsp;1.1&nbsp;<a href="#AddInfo">Add Information</a><br />
&nbsp;&nbsp;&nbsp;&nbsp;1.2&nbsp;<a href="#AddRoutes">Add Tour Routes</a><br />

2.&nbsp;<a href="#Align">Align Tours with Searches</a><br />
&nbsp;&nbsp;&nbsp;&nbsp;2.1&nbsp;<a href="#SelectTour">Select Tour</a><br />
&nbsp;&nbsp;&nbsp;&nbsp;2.1&nbsp;<a href="#Criteria">Align with Search Criteria</a><br />

3.&nbsp;<a href="#Edit">Updating Existing Information</a><br />
&nbsp;&nbsp;&nbsp;&nbsp;3.1&nbsp;<a href="#EditInfo">Edit Information</a><br />
&nbsp;&nbsp;&nbsp;&nbsp;3.2&nbsp;<a href="#EditRoutes">Edit Tour Routes</a><br />
&nbsp;&nbsp;&nbsp;&nbsp;3.3&nbsp;<a href="#Delete">Delete Tour</a><br />


<a name="Add"></a>
<h3>Adding Tour Information</h3>
			<br />
			<a name="AddInfo"></a>
			<p><h4>Add Information</h4></p>
			<br />
			<p>Adding tour information is a breeze with our easy to follow process. Simply click on the "Add Tour" link from your Tour Operator home page and you will be directed to an input page where you can enter your Tour Name, Description, Currency, Price and whether the listed tour is on demand or not.</p>
			<br />
			<p><img src="<c:url value="/img/operator_add_tour.jpg"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
			<br />
			<br />
			<a name="AddRoutes"></a>
			<p><h4>Add Tour Routes</h4></p>
			<br />
			<p>Adding tour information is a breeze with our easy to follow process. Simply enter the location name, click "Search" and Google Map will display the map. Click the map to start adding the first point of the routes, then a marker will appear on the map, and click "Add Point". Continue this step for every points that you want to add as the tour routes. You can also delete a particular marker by clicking on the marker and click "Delete selected point". If you want to clear all markers on the map, simply click "Delete All Points".</p>
			<br />
			<p><img src="<c:url value="/img/operator_add_routes.png"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
<a name="Align"></a>
<h3>Aligning Tours with Searches</h3>
			<br />
			<p>There are two steps in aligning the tour with it's specific search criteria. Firstly you must click on the "Align Tour" link from your home page which will take you to a list of your currently created tours.</p>
			<br />
			<a name="SelectTour"></a>
			<p><h4>Select Tour</h4></p>
			<br />
			<p>Then it is simply a matter of selecting the tour that you wish to align by clicking on the corresponding "align" link on the right hand side.</p>
			<br />
			<p><img src="<c:url value="/img/operator_align_1.jpg"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
			<br />
			<br />
			<a name="Criteria"></a>
			<p><h4>Align With Search Criteria</h4></p>
			<br />
			<p>From there you are directed to an input page where you may select the criteria that you wish to use to align the tour with the searches as demonstrated in the screenshot below.</p>
			<br />
			<p><img src="<c:url value="/img/operator_align_2.jpg"/>" width="690px" /></p>
			<br />
			<p>Voila! You're done.</p>
			<br />
			<a href="#Top">Back to top</a>
<a name="Edit"></a>
<h3>Updating Existing Information</h3>
			<br />
			<p>Editing a tour is as simple as any other process on Antipodes. Clicking on the "Edit/Delete tour" link from the homepage will take you to the following screen where you can choose to either edit the details of the tour, or delete the tour altogether.</p>
			<br />
			<p><img src="<c:url value="/img/operator_list.jpg"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
			<br />
			<br />
			<a name="EditInfo"></a>
			<p><h4>Edit Information</h4></p>
			<br />
			<p>If you click on the "Edit" link then you will be directed to the following page where you can modify any tour details that you wish.</p>
			<br />
			<p><img src="<c:url value="/img/operator_edit_tour.jpg"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
			<br />
			<br />
			<a name="EditRoutes"></a>
			<p><h4>Edit Tour Routes</h4></p>
			<br />
			<p>You can move the existing markers by dragging the markers along the map. Same as adding routes, you can also add new markers and delete them as well.</p>
			<br />
			<p><img src="<c:url value="/img/operator_edit_routes.png"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
			<br />
			<br />
			<a name="Delete"></a>
			<p><h4>Delete Tour</h4></p>
			<br />
			<p>Clicking on the "Delete" link on the right hand side of the page will prompt you to confirm that you want to delete the corresponding tour. If this is the case, click "Yes" on the dialogue box.</p>
			<br />
			<p><img src="<c:url value="/img/operator_delete_tour.jpg"/>" width="690px" /></p>
			<a href="#Top">Back to top</a>
			<br />
			
</div>
</body>
</html>