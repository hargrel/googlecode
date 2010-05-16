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
				oTable = $('#example').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"aoColumns": [ 
						null,
						null,
						{ "bSortable": false },
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

<h2>Account List</h2>
<div class="demo_jui">
	<table cellpadding="0" cellspacing="0" border="0" id="example" class="display">
		<thead>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>User Type</th>
			<th></th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${accounts}" var="account">
			
			<tr class="gradeA">
				<td><c:out value="${account.userID}" /></td>
				<td><c:out value="${account.userName}" /></td>
				<td><c:out value="${account.password}" /></td>
				<td><c:out value="${account.userType}" /></td>
			
				<td class="center">
					<form style="margin:0px; padding: 0px;" name="edit_${account.userID}" action="editAccount.html" method="get">
						<input type="hidden" name="userID" value="${account.userID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${account.userID}'].submit()">Edit</a>
				</td>
				
				<td class="center">
					<form style="margin:0px; padding: 0px;" name="delete_${account.userID}" action="accountList.html" method="post">
						<input type="hidden" name="userID" value="${account.userID}" />
					</form>
					<a href="#" style="color: blue" onclick="return confirmDelete(${account.userID});">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
	<input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" style="float: right; margin-top: 20px;"/>

	
</body>
</html>