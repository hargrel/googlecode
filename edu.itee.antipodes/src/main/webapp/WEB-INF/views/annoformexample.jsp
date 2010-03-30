<%@ include file="/WEB-INF/views/include.jsp" %>

<html>

<head>
	<title><fmt:message key="title" /></title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/navlinks.jsp" />
	<h1><fmt:message key="title" /></h1>
	<h3>Tours</h3>
	<table style="width: 1000px;">
		<tr>
			<td style="width: 80px;">tourID</td>
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
				<td>
					<form style="margin:0px; padding: 0px;" name="edit_${tour.tourID}" action="annoselecttourexample.html" method="get">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['edit_${tour.tourID}'].submit()">edit</a>
				</td>
				<td>
					<form style="margin:0px; padding: 0px;" name="delete_${tour.tourID}" action="annoformexample.html" method="post">
						<input type="hidden" name="tourID" value="${tour.tourID}" />
					</form>
					<a href="#" style="color: blue;" onclick="document['delete_${tour.tourID}'].submit()">delete</a>
				</td>
			</tr>
		</c:forEach>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td><a href="annoformaddexample.html" style="color: blue;">add tour</a></td>
		</tr>
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
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.Tour;
import edu.itee.antipodes.service.TourManager;

@Controller
@RequestMapping("/annoformexample.html")
public class AnnoFormExampleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "annoformexample";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String deleteTour(@RequestParam("tourID") int tourID, Model model) {
		tourManager.dropTourByID(tourID);
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "annoformexample";
	}
	
	@Autowired
	TourManager tourManager;
}

</pre>