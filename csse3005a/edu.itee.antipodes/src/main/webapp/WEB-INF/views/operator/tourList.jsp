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
						null,
						null,
						{ "bSortable": false },
						{ "bSortable": false }
						]
				});
			} );
</script>
<script type="text/javascript">
function confirmDelete(id)
{
	var answer = confirm("Are you sure you want to delete this record?")
    if (answer){
    	document['delete_'+id].submit();
    }
   
    return false;
}
</script>
</head>
<body>

	<h2>Tour List</h2>
	<div class="demo_jui">
	<table cellpadding="0" cellspacing="0" border="0" id="tour" class="display">
		<thead>
		<tr>
			<th>ID</th>
			<th width="120">Tour Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>On Demand</th>	
			<th></th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${tours}" var="tour">
			
			<tr class="gradeA">
				<td valign="top"><c:out value="${tour.tourID}" /></td>
				<td valign="top"><c:out value="${tour.tourName}" /></td>	
				<td valign="top"><c:out value="${tour.tourDesc}" escapeXml="false"/></td>
				<td valign="top"><c:out value="${tour.price}" />&nbsp;<c:out value="${tour.currency}" /></td>
				<td valign="top" class="center">
				<c:if test="${tour.onDemand == '0'}">
				<c:out value="No" /></c:if>
				<c:if test="${tour.onDemand == '1'}">
				<c:out value="Yes" /></c:if>
				</td>
				
				<td valign="top">
					<form style="margin:0px; padding: 0px;" name="edit_${tour.tourID}" action="editTour.html" method="get">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${tour.tourID}'].submit()">Edit</a>
				</td>
				<td valign="top">
					<form style="margin:0px; padding: 0px;" name="delete_${tour.tourID}" action="tourList.html" method="post">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="return confirmDelete(${tour.tourID});">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>

</div>
</body>
</html>