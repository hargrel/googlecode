<%@ include file="/WEB-INF/views/template/includes.jsp" %>
<%@ include file="/WEB-INF/views/template/beginHtml.jsp" %>
<%@ include file="/WEB-INF/views/template/toplinks.jsp" %>
<%@ include file="/WEB-INF/views/template/banner.jsp" %>

<div id="content">
  <h2>hibernate.jsp</h2>
  <br />
  <p>This is a .jsp page returned from the Spring controller HibernateController.java</p>
  <p>Front Controller -> HibernateController -> hibernate.jsp</p>
  <br />
  <p>I am hibernate!</p>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
<%@ include file="/WEB-INF/views/template/endHtml.jsp" %>