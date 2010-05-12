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
	</style>
</head>
<body>

<h2>Monthly Fee List</h2>
	<div id="Table">
	<span class="form-error-message"><c:out value="${errorMessage}" /></span>
	<table style="width: 500px;">
		<thead>
		<tr>
			<th style="width: 60px;">Fee ID</th>
			<th>Month</th>
			<th>Fee</th>
			<th></th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${listedTourFees}" var="listedTourFee">
		<form style="margin:0px; padding: 0px;" name="save_${listedTourFee[3]}" action="feeList.html" method="post">
			<tr>
				
				<td><c:out value="${listedTourFee[3]}" /></td>
				<td><c:out value="${listedTourFee[1]}" /></td>
				<td><input type="text" name="fee" value="${listedTourFee[2]}" size="5" />
				</td>
			
				<td>
					<input type="hidden" name="listID" value="${listedTourFee[0]}" />
					<input type="hidden" name="feeID" value="${listedTourFee[3]}" />
					
					<a href="#" style="color: blue;" onclick="document['save_${listedTourFee[3]}'].submit()">Save</a>
				</td>
				
			</tr>
		</form>
		</c:forEach>
		</tbody>
	
	</table>
	<input type="button" value="Cancel" onClick="window.location.href='<c:url value="manageFee.html"/>'" style="float: right; margin-right: 20px; margin-top: 10px;"/>
	</div>
	
</body>
</html>