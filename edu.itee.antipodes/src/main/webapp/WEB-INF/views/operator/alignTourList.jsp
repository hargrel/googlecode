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
				oTable = $('#tour').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"aoColumns": [ 
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

	<h2>Align Tour List</h2>
	<div class="demo_jui">
	<table cellpadding="0" cellspacing="0" border="0" id="tour" class="display">
		<thead>
		<tr>
			<th>ID</th>
			<th>Tour Name</th>
			<th>Duration</th>
			<th></th>	
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${tours}" var="tour">
			
			<tr class="gradeA">
				<td><c:out value="${tour.tourID}" /></td>
				<td><c:out value="${tour.tourName}" /></td>	
				<c:if test="${tour.onDemand == '0'}">
				<td><c:out value="${tour.totalDays}" />&nbsp; days</td>	
				</c:if>
				<c:if test="${tour.onDemand == '1'}">
				<td></td>	
				</c:if>
				<td class="center">
					<form style="margin:0px; padding: 0px;" name="align_${tour.tourID}" action="alignTour.html" method="get">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['align_${tour.tourID}'].submit()">Align</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</body>
</html>