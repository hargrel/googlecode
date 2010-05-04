
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<HEAD>
<META HTTP-EQUIV=REFRESH CONTENT="1;URL=redirect.html?username=<sec:authentication property="principal.username" />">
</HEAD>
<h2>Redirecting...</h2>