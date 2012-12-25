<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/blue-motion/style.css'/>" />
        <link rel="stylesheet" type="text/css" media="print" href="<c:url value='/styles/${appConfig["csstheme"]}/print.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/jquery/jquery.ui.button.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/jquery/jquery.ui.autocomplete.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/jquery/jquery.ui.datepicker.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/jquery/jquery-ui-1.8.14.custom.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/style.css'/>" />
		
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery/jquery-1.5.1.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery/jquery-ui-1.8.11.custom.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery/ui/jquery.ui.accordion.js'/>"></script>
        <decorator:head/>
    </head>
    
	<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
	    <div id="templatemo_outer_wrapper">
	    	<div id="templatemo_wrapper">
	    		<div id="templatemo_header">
	    			<div id="site_title">
                        <h1>
                        	<a href="/" target="_parent">
		                		<span><fmt:message key="webapp.tagline"/></span>
		                	</a>
		                </h1>  
		            </div> <!-- end of site_title -->
		            
	    		</div> <!-- end of header -->

	    		 <div id="templatemo_menu">
	    		 	<div class="slogan" >LET'S MAKE THINGS SIMPLER AND BETTER</div>
	    		 	<div class="logout">
						<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
							<ul>
	    		 				<menu:displayMenu name="Logout"/></div>
	    		 			</ul>
	    		 		</menu:useMenuDisplayer>
		    		 	<div class="cleaner">
	    		 	</div>
	    		 	<div class="mainpage">
						<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
							<ul>
	    		 				<menu:displayMenu name="MainMenu"/></div>
	    		 			</ul>
	    		 		</menu:useMenuDisplayer>
		    		 	<div class="cleaner">
	    		 	</div>
	    		 		<jsp:include page="/common/admin_horizon.jsp"/>
	    		 </div><!-- end of templatemo_menu -->
	    		 
	    		 	<div class="cleaner"></div>
	    		 <!-- <div id="templatemo_main_top"></div> -->
	    		 
	    		 <div id="templatemo_main">
	    		 	<div id="templatemo_sidebar">
	    		 		<jsp:include page="/common/admin_vertical.jsp"/>
	    		 	</div><!-- end of sidebar -->
	    		 	
	    		 	<div id="templatemo_content">
	    		 		<%@ include file="/common/messages.jsp" %>
	                	<h2 class="content-title"><decorator:getProperty property="meta.heading"/></h2>
	                	<decorator:body/>
	    		 	</div><!-- end of content -->
	    		 	
	    		 	<div class="cleaner"></div>
	    		 </div><!-- end of templatemo_main -->
	    		 
 	    		 <div id="templatemo_main_bottom"></div>
 	    		 
	    		 <div id="templatemo_footer">
	    		 	<jsp:include page="/common/footer.jsp"/>
	    		 </div> 
	    				
	    	</div> <!-- end of wrapper -->
	    	
	    </div><!-- end of outter wrapper -->
	    
	    <script type="text/javascript">
	    	var icons = {
				header: "ui-icon-circle-arrow-e",
				headerSelected: "ui-icon-circle-arrow-s"
			};
			/* $("#vertical_menu").accordion({
				event: "mouseover",
				autoHeight: false,
				navigation: true,
				icons: icons
			}); */
			
		</script>
	</body>
</html>
