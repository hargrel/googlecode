<%@ include file="/WEB-INF/views/include.jsp" %>

<html>

<head>
	<title><fmt:message key="title" /></title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/navlinks.jsp" />
	<h1><fmt:message key="title" /></h1>
	<h3>Tours</h3>
	<table style="width: 900px;">
		<tr>
			<td>tourID</td>
			<td>tourName</td>
			<td>tourDesc</td>
			<td>price</td>
			<td>totalDays</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<c:forEach items="${model.tours}" var="tour">
			<tr>
				<td><c:out value="${tour.tourID}" /></td>
				<td><c:out value="${tour.tourName}" /></td>
				<td><c:out value="${tour.tourDesc}" /></td>
				<td><i>$<c:out value="${tour.price}" /></i></td>
			 	<td><c:out value="${tour.totalDays}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
	<pre>
	
CONTROLLER CODE - Does not use @Annotations
-------------------------------------------
	
package edu.itee.antipodes.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.itee.antipodes.service.TourManager;

public class InventoryExampleController implements Controller {
	
	private TourManager tourManager;

    public ModelAndView handleRequest(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	
    	Map<String, Object> myModel = new HashMap<String, Object>();
    	myModel.put("tours", this.tourManager.getTours());

        return new ModelAndView("inventoryexample", "model", myModel);
        
    }
    
    public void setTourManager(TourManager tourManager) {
        this.tourManager = tourManager;
    }

}
	
	</pre>
</body>
	
</html>