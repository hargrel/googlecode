<%@ include file="/WEB-INF/views/template/includes.jsp" %>
<%@ include file="/WEB-INF/views/template/beginHtml.jsp" %>
<%@ include file="/WEB-INF/views/template/toplinks.jsp" %>
<%@ include file="/WEB-INF/views/template/banner.jsp" %>

<div id="content">

  <h2/>Luke's Uncaught Exceptions Page</h2>
  <br />

  <div id="exception">
  
<% 
try {
	// The Servlet spec guarantees this attribute will be available
	Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception"); 

	if (exception != null) {
		if (exception instanceof ServletException) {
			// It's a ServletException: we should extract the root cause
			ServletException sex = (ServletException) exception;
			Throwable rootCause = sex.getRootCause();
			if (rootCause == null)
				rootCause = sex;
			out.println("** Root cause is: "+ rootCause.getMessage());
			rootCause.printStackTrace(new java.io.PrintWriter(out)); 
		}
		else {
			// It's not a ServletException, so we'll just show it
			exception.printStackTrace(new java.io.PrintWriter(out)); 
		}
	} 
	else  {
    	out.println("No error information available");
	} 

	// Display cookies
	out.println("\nCookies:\n");
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
    	for (int i = 0; i < cookies.length; i++) {
      		out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
		}
	}
	    
} catch (Exception ex) { 
	ex.printStackTrace(new java.io.PrintWriter(out));
}
%>

  </div>
  
</div>

<br/>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>
<%@ include file="/WEB-INF/views/template/endHtml.jsp" %>
