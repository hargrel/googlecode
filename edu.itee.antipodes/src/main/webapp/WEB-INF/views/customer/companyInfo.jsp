<%@ include file="/WEB-INF/views/include.jsp" %>

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
				oTable = $('#company').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"aoColumns": [ 
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

<body onunload="GUnload()">

<h2><c:out value="${listedTours[0].operator.operatorName}" /></h2>

<table border="0" align="center" width=100% style="border-collapse:collapse">
	<tr>
		<!-- Company Info -->
		<td valign="top" width="160"><b>Company Info: </b></td>
		<td valign="top"><c:out value="${listedTours[0].operator.companyInfo}" escapeXml="false"/></td>
	</tr>

	<tr>
		<!-- Membership Expired -->
		<td valign="top"><b>Membership Expired: </b></td>
		<td valign="top"><fmt:formatDate value="${listedTours[0].operator.membershipExpired}" pattern="d MMM yyyy"/></td>
	</tr>
		
	<tr>
		<!-- Email -->
		<td valign="top"><b>Email: </b></td>
		<td valign="top"><a style="color: blue;" href='<c:url value="contactTourOperator.html"/>'><c:out value="${listedTours[0].operator.email}" /></a></td>
	</tr>
	
</table>

<h3>List of tours:</h3>
	<div class="demo_jui">
	<table cellpadding="0" cellspacing="0" border="0" id="company" class="display">
		<thead>
		<tr>
			<th>Tour Name</th>
			<th>Tour Price</th>
			<th>Start Date</th>
			<th>Finish Date</th>
			<th>Total Days</th>
			<th></th>
		</tr>
		</thead>
		<tbody>

		<c:forEach items="${listedTours}" var="listedTour">
			<c:forEach items="${listedTour.tour.tourDates}" var="tourDate">
				<tr class="gradeA">
					<td><c:out value="${listedTour.tour.tourName}" /></td>
					<td><c:out value="${listedTour.tour.price}" />&nbsp;<c:out value="${listedTour.tour.currency}" /></td>
					<td><fmt:formatDate value="${tourDate.startDate}" pattern="d MMM yyyy"/></td>
					<td><fmt:formatDate value="${tourDate.finishDate}" pattern="d MMM yyyy"/></td>
					<td><c:out value="${listedTour.tour.totalDays}" />&nbsp;days</td>
					<td class="center">
						<form style="margin:0px; padding: 0px;" name="info_${listedTour.listID}" 
							action="tourInfo.html" method="post">
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
	</div>
	
</body>
</html>
