<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
	<ul id="vertical_menu" class="vertical_menu">
	    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
	    <menu:displayMenu name="CodesMenu"/>
	    <menu:displayMenu name="PlaceMenu"/>
	    <menu:displayMenu name="CustomerMenu"/>
	    <menu:displayMenu name="CurrencyMenu"/>
	    <menu:displayMenu name="CommodityMenu"/>
	    <menu:displayMenu name="EquipmentMenu"/>	    
	    <menu:displayMenu name="PayingMenu"/>
	    <menu:displayMenu name="ParammeterMenu"/>
	    <menu:displayMenu name="VoyageMenu"/>
	    <menu:displayMenu name="AccountMenu"/>  	    
	    <menu:displayMenu name="AdminMenu"/>
	    <menu:displayMenu name="Logout"/>
	</ul>
</menu:useMenuDisplayer>