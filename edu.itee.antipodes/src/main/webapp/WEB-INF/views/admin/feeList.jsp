<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Monthly Fee List</h2>
	<div id="Table">
	<table style="width: 500px;">
		<thead>
		<tr>
			<th style="width: 60px;">ID</th>
			<th>Month</th>
			<th>Year</th>
			<th>Fee</th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${fees}" var="fee">
			
			<tr>
				<td><c:out value="${fee.feeID}" /></td>
				<td><c:out value="${fee.month}" /></td>
				<td><c:out value="${fee.year}" /></td>
				<td><c:out value="${fee.fee}" /></td>
			
				<td>
					<form style="margin:0px; padding: 0px;" name="edit_${fee.feeID}" action="feeList.html" method="get">
						<input type="hidden" name="feeID" value="${fee.feeID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${fee.feeID}'].submit()">Edit</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	<input type="button" value="Cancel" onClick="window.location.href='<c:url value="SAhome.html"/>'" style="float: right; margin-right: 20px; margin-top: 10px;"/>
	</div>
	
</body>
</html>