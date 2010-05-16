<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="<c:url value="/css/smoothness/jquery-ui-1.7.2.custom.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/js/dataTables/demo_table_jui.css"/>" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/dataTables/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				oTable = $('#result').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"aoColumns": [ 
						null,
						null,
						null,
						null,
						null,
						{ "bSortable": false }
						]
				});
			} );
</script>
</head>

<body>

<h2>Search Results</h2>
	<div class="demo_jui">
	<table cellpadding="0" cellspacing="0" border="0" id="result" class="display">
		<thead>
		<tr>
			<th>Tour Name</th>
			<th>Operator Name</th>
			<th>Start Date</th>
			<th>Finish Date</th>
			<th>Tour Price</th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${listedTours}" var="listedTour">
			<c:forEach items="${listedTour.tour.tourDates}" var="tourDate">
				<tr class="gradeA">
					<td><c:out value="${listedTour.tour.tourName}" /></td>
					<td><c:out value="${listedTour.operator.operatorName}" /></td>
					<td><c:out value="${tourDate.startDate}" /></td>
					<td><c:out value="${tourDate.finishDate}" /></td>
					<td><c:out value="${listedTour.tour.price}" />&nbsp;<c:out value="${listedTour.tour.currency}"/></td>
					
					<!-- This is a currency sample 
					<td><fmt:formatNumber type="currency" value="${cur:convert(listedTour.tour.price,listedTour.tour.tourName,listedTour.tour.tourName)}" /></td> -->
					
					<td>
						<form style="margin:0px; padding: 0px;" name="info_${listedTour.listID}" 
							action="tourInfo.html?listID=${listedTour.listID}" method="post">
							<input type="hidden" name="listID" value="${listedTour.listID}" />
						</form>
						<a href="#" style="color: blue;" 
							onclick="document['info_${listedTour.listID}'].submit()">More info</a>
					</td>
				</tr>
			</c:forEach>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="Back" onClick="window.location.href='<c:url value="search.html"/>'" 
		style="float: right; margin-top: 20px;"/>
	</div>
	
	
</body>
</html>