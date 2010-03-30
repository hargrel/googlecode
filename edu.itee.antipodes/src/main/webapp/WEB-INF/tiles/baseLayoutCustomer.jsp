<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
    
    <div id="content">

	<div id="main">
    <tiles:insertAttribute name="header" />
    
               <div id="tab">
                    <tiles:insertAttribute name="menu" />
                </div>
            
            <div id="context">
                    <tiles:insertAttribute name="body" />
            </div>
            
            </div>
            <div id="end"></div>
            	<div id="link">
            		<tiles:insertAttribute name="link" />
            	</div>
                <div id="footer1">
                    <tiles:insertAttribute name="footer" />
                </div>
            </div>
    </body>
</html>
