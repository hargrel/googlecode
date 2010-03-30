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
		<c:forEach items="${tours}" var="tour">
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
	
CONTROLLER CODE - Uses @Annotations
-------------------------------------------
	
package edu.itee.antipodes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.Tour;
import edu.itee.antipodes.service.TourManager;

@Controller
@RequestMapping("/annoinventoryexample.html")
public class AnnoInventoryExampleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "inventoryexample";
	}
	
	@Autowired
	TourManager tourManager;
}
	
	</pre>
</body>
	
</html>