<%@ include file="/WEB-INF/views/include.jsp"%>

<html>

<head>
	<title><fmt:message key="title" /></title>
</head>

<body>

	<jsp:include page="/WEB-INF/views/navlinks.jsp" />

	<h1><fmt:message key="title" /></h1>

	<p><fmt:message key="greeting" /></p>
	
	<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
	
	<pre>
	
CONTROLLER CODE - Uses @Annotations
-----------------------------------
	
package edu.itee.antipodes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationExampleController {

	@RequestMapping("/annotationexample.html")
	public void exampleHandler() {
	}

}
	
	</pre>

</body>
	
</html>