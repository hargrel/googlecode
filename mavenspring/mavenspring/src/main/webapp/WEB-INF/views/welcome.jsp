<%@ include file="/WEB-INF/views/template/includes.jsp" %>
<%@ include file="/WEB-INF/views/template/beginHtml.jsp" %>
<%@ include file="/WEB-INF/views/template/toplinks.jsp" %>
<%@ include file="/WEB-INF/views/template/banner.jsp" %>

<div id="content">
  <h2>welcome.jsp</h2>
  <br />
  <p>This is the default view defined in the dispatcher servlet.</p>
  <p>Can be found in mvc.config.xml as &lt;mvc:view-controller path="/" view-name="welcome" /&gt; </p>
  <br />
  <p>
     <script type="text/javascript">
       javascript_enabled();
    </script>
  </p>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
<%@ include file="/WEB-INF/views/template/endHtml.jsp" %>
