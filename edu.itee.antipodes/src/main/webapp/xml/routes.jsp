<?xml version="1.0" encoding="ISO-8859-1"?>
<%@ page contentType="text/xml;charset=ISO-8859-1" %>
<%@ page language="java" import="java.util.*,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,edu.itee.antipodes.utils.SpringApplicationContext,edu.itee.antipodes.repository.ListedTourDaoHibernate,edu.itee.antipodes.domain.db.Image,edu.itee.antipodes.repository.ImageDaoHibernate" %>
<markers>
<%
int listID = Integer.parseInt(request.getParameter("listID"));
ListedTourDaoHibernate lt = SpringApplicationContext.getListedTourDao();
ImageDaoHibernate idh = SpringApplicationContext.getImageDao();
List<Object[]> map = lt.getLocationDetailsByListedTourID(listID);

List<Image> img = idh.getImageByTourID(lt.getListedTourByID(listID).getTourID());


%>

<marker lat="<%out.print(map.get(0)[1].toString()); %>" lng="<%out.print(map.get(0)[2].toString());%>" pt="<%out.print(lt.getListedTourByID(listID).getTour().getPoints().toString());%>" lvl="<%out.print(lt.getListedTourByID(listID).getTour().getLevels().toString());%>" img="<%out.print(img.get(0).getUrl());%>"></marker>
</markers>