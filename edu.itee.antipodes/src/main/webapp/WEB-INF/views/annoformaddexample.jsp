<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<td><a href="annoformexample.html" style="color: blue;">cancel</a></td>
		</tr>
		<%--
		<form style="margin:0px; padding: 0px;" name="add_tour" action="annoformaddexample.html" method="post">
			<tr>
				<td><input type="hidden" name="tourID" value="23"/>23</td>
				<td><input type="text" name="tourName" size="15" /></td>
				<td><input type="text" name="tourDesc" size="50"/></td>
				<td><input type="text" name="price" size="6"/></td>
				<td><input type="text" name="totalDays" size="2"/></td>
				<td><a href="#" style="color: blue;" onclick="document['add_tour'].submit()">add</a></td>
			</tr>
		</form>--%>
		<form:form commandName="add_tour">
		<tr>
		
		
		<form:input path="tourName" size="40" cssErrorClass="form-error-field"/>
		<form:input path="tourDesc" size="40" cssErrorClass="form-error-field"/>
		<form:input path="price" size="40" cssErrorClass="form-error-field"/>
		<form:input path="totalDays" size="40" cssErrorClass="form-error-field"/>
		<input type="submit" value="Submit" />
		</tr>
</form:form>
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
@RequestMapping("/annoformaddexample.html")
public class AnnoFormAddExampleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "annoformaddexample";
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
		
		tourManager.addTour(tour);
		
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "annoformexample";
	}
	
	@Autowired
	TourManager tourManager;
}


</pre>