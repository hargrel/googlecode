<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style>
		.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
		.success-message { font-weight: bold; color: #900; font-size: 12px; }
	</style>
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
						{ "bSortable": false }
						]
				});
			} );
</script>
</head>
<body>

<h2>Monthly Fee List
<span class="success-message"><c:out value="${successMessage}" /></span></h2>
	<div class="demo_jui">
	<span class="form-error-message"><c:out value="${errorMessage}" /></span>
	<table cellpadding="0" cellspacing="0" border="0" id="fee" class="display">
		<thead>
			
		<tr>
			<th style="width: 60px;">Fee ID</th>
			<th>Month</th>
			<th>Fee</th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${listedTourFees}" var="listedTourFee">
			<tr class="gradeA">
				
				<td><c:out value="${listedTourFee[3]}" /></td>
				<td><fmt:formatDate value="${listedTourFee[1]}" pattern="MMMMM"/></td>
			
				<td>
				<form style="margin:0px; padding: 0px;" name="save_${listedTourFee[3]}" action="feeList.html" method="post">
					<input type="text" name="fee" value="${listedTourFee[2]}" size="5" />
					<input type="hidden" name="listID" value="${listedTourFee[0]}" />
					<input type="hidden" name="feeID" value="${listedTourFee[3]}" />
					
					<a href="#" style="color: blue;" onclick="document['save_${listedTourFee[3]}'].submit()">Save</a>
				</form>
				</td>
				
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	</div>
	
</body>
</html>