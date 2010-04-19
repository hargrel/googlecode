<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize ifAllGranted="ROLE_ANONYMOUS">
<a class="home" href="<c:url value="SAhome.html"/>" >Admin Login</a>
</sec:authorize>