<%@ include file="/WEB-INF/views/include.jsp" %>

<html>

<head>
	<title><fmt:message key="title" /></title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/navlinks.jsp" />
	<h1><fmt:message key="title" /></h1>
	<h3>update tour</h3>
	<form style="margin:0px; padding: 0px;" name="updateTour" action="annoselecttourexample.html" method="post">
		<table style="width: 800px">
			<tr><td>tourID</td><td><input type="hidden" name="tourID" value="${tour.tourID}" /><c:out value="${tour.tourID}" /></td></tr>
			<tr><td>tourName</td><td><input type="text" name="tourName" value="${tour.tourName}" /></td></tr>
			<tr><td>tourDesc</td><td><input type="text" name="tourDesc" value="${tour.tourDesc}" size="50" /></td></tr>
			<tr><td>price</td><td><input type="text" name="price" value="${tour.price}" /></td></tr>
			<tr><td>totalDays</td><td><input type="text" name="totalDays" value="${tour.totalDays}" /></td></tr>
		</table>
		<br />
		<input type="submit" value="update">
	</form>
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
@RequestMapping("/annoselecttourexample.html")
public class AnnoSelectTourExampleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showTour(@RequestParam("tourID") int tourID, Model model) {
		Tour tour = tourManager.getTourByID(tourID);
		model.addAttribute("tour", tour);
		return "annoselecttourexample";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateTour(@RequestParam("tourID") int tourID, @RequestParam("tourName") String tourName, 
			@RequestParam("tourDesc") String tourDesc, @RequestParam("price") double price, 
			@RequestParam("totalDays") int totalDays, Model model) {
		Tour tour = new Tour();
		tour.setTourID(tourID);
		tour.setTourName(tourName);
		tour.setTourDesc(tourDesc);
		tour.setPrice(price);
		tour.setTotalDays(totalDays);
		
		tourManager.updateTour(tour);
		
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "annoformexample";
	}
	
	@Autowired
	TourManager tourManager;
}

</pre>