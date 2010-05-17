<?xml version="1.0" encoding="ISO-8859-1"?>
<%@ page contentType="text/xml;charset=ISO-8859-1" %>
<%@ page language="java" import="java.util.*,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,edu.itee.antipodes.utils.SpringApplicationContext,edu.itee.antipodes.repository.ListedTourDaoHibernate" %>
<markers>
<%
int listID = Integer.parseInt(request.getParameter("listID"));
ListedTourDaoHibernate lt = SpringApplicationContext.getListedTourDao();
List<Object[]> map = lt.getLocationDetailsByListedTourID(listID);
List<Object[]> img = lt.getImageDetailsByListedTourID(listID);
%>

<marker lat="<%out.print(map.get(0)[1].toString()); %>" lng="<%out.print(map.get(0)[2].toString());%>" pt="<%out.print(map.get(0)[3].toString());%>" lvl="<%out.print(map.get(0)[4].toString());%>" img="<%out.print(img.get(0)[1].toString());%>"></marker>
</markers>