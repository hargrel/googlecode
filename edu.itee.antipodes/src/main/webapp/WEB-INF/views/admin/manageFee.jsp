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
				oTable = $('#fee').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"aoColumns": [ 
						null,
						null,
						null,
						null,
						null,
						{ "bSortable": false },
						{ "bSortable": false }
						]
				});
			} );
		</script>
</head>
<body>
<h2>Manage Fees</h2>
<div class="demo_jui">
<table cellpadding="0" cellspacing="0" border="0" id="fee" class="display">
	<thead>
	<tr>
		<th style="width: 60px;">List ID</th>
		<th>Tour ID</th>
		<th>Operator ID</th>
		<th>Listed From</th>
		<th>Listed To</th>
		<th>Total Fee</th>
		<th></th>
	</tr>
	</thead>

	<tbody>
	<c:forEach items="${listedTours}" var="listedTour">
		
		<tr class="gradeA">
			<td><c:out value="${listedTour[0]}" /></td>
			<td><c:out value="${listedTour[1]}" /></td>
			<td><c:out value="${listedTour[2]}" /></td>
			<td><fmt:formatDate value="${listedTour[3]}" pattern="d MMM yyyy"/></td>
			<td><fmt:formatDate value="${listedTour[4]}" pattern="d MMM yyyy"/></td>
			<td><c:out value="${listedTour[5]}" /></td>
			<td class="center">
				<form style="margin:0px; padding: 0px;" name="manage_${listedTour[0]}" action="feeList.html" method="get">
				<input type="hidden" name="listID" value="${listedTour[0]}" />
				</form>
				<a href="#" style="color: blue" onclick="document['manage_${listedTour[0]}'].submit()">Manage</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>

</table>

</div>
</body>
</html>