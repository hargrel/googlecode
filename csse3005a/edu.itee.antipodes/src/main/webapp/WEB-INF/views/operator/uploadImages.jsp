<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<style>
			.form-error-field { background-color: #FFC; }
			.form-error-message { font-weight: bold; color: #900; font-size: 10px; }
			.hide { display: none; }
		</style>
<link rel="stylesheet" href="<c:url value="/js/jwysiwyg/jquery.wysiwyg.css"/>" />
<script type="text/javascript" src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jwysiwyg/jquery.wysiwyg.js"/>"></script>
<script type="text/javascript">
  $(function()
  {
      $('#tourDesc').wysiwyg();
  });
</script>
</head>
<body>

<h2>Upload Images</h2>
<p>You may upload up to <c:out value="${numberOfFiles}"/> images.<br/>
Accepted file types are PNG and JPG.</p>
<!-- Form name: uploadImages -->
<!-- Attribute names: tourID -->
<form method="post" action="uploadImages.html" enctype="multipart/form-data">
<table border="0" cellspacing="2" style="border-collapse:collapse; padding: 5px">			
<tr>
    <td><input type="hidden" name="tourID" value="${tourID}" />
    <c:forEach items="${files}" var="file">
            <input type="file" name="${file}"/><br/>
    </c:forEach>
    <span class="hide">
	<c:choose> 
		<c:when test="${numberOfFiles == 1}" > 
		<input type="file" name="file2"/>
		<input type="file" name="file3"/>
		<input type="file" name="file4"/>
		</c:when> 
		<c:when test="${numberOfFiles == 2}" > 
		<input type="file" name="file3"/>
		<input type="file" name="file4"/>
		</c:when> 
		<c:when test="${numberOfFiles == 3}" > 
		<input type="file" name="file4"/>
		</c:when> 
	</c:choose>  
    </span>
    <br/>
    <input type="hidden" name="addorEdit" value="<c:out value="${addorEdit}"/>" />
    <input type="submit" value="Done" />
    </td>
</tr>
</table>
</form>
</body>
</html>


