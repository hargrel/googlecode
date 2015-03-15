<%@ include file="/WEB-INF/views/template/includes.jsp" %>
<%@ include file="/WEB-INF/views/template/beginHtml.jsp" %>
<%@ include file="/WEB-INF/views/template/toplinks.jsp" %>
<%@ include file="/WEB-INF/views/template/banner.jsp" %>

<div id="content">
  <h2>time.jsp</h2>
  <br />
  <p>This is a .jsp page returned from the Spring controller ServicesController.java</p>
  <p>Front Controller -> ServicesController -> time.jsp</p>
  <br />
  <p>By the way, it is ${time}.</p>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
<%@ include file="/WEB-INF/views/template/endHtml.jsp" %>