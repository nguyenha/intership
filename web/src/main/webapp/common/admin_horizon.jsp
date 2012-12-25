<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
	<ul >
	    <c:if test="${empty pageContext.request.remoteUser}">
	    	<li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li>
	    </c:if>
	    <menu:displayMenu name="GuessMenu"/>
	    <menu:displayMenu name="Logout"/> 
	    <menu:displayMenu name="MainMenu"/>
 	    <menu:displayMenu name="UserMenu"/> 
	    <menu:displayMenu name="BookingMenu"/>
 	</ul>
</menu:useMenuDisplayer>