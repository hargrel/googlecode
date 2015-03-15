<?xml version="1.0" encoding="ISO-8859-1"?>
<%@ page contentType="text/xml;charset=ISO-8859-1" %>
<%@ page language="java" import="java.util.List,edu.itee.antipodes.domain.db.Location,edu.itee.antipodes.utils.SpringApplicationContext,edu.itee.antipodes.repository.LocationDao" %>
<markers>
<%
LocationDao ld = SpringApplicationContext.getLocationDao();
List<Location> ll = ld.getLocationList();
for (Location location : ll){
%>
<marker lat="<%out.print(Double.toString(location.getLatitude()));%>" lng="<%out.print(Double.toString(location.getLongitude()));%>" loc="<%out.print(location.getLocationName());%>"></marker>
<%
}
%>
</markers>