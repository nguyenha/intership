<%@include file="/WEB-INF/common/taglibs.jsp" %>
<h1>Hello <security:authentication property="principal.username" />!</h1>

<p>
	Click <a href='<s:url value="/"></s:url>'>here</a> to navigate to home page.	
	Click <a href='<s:url value="/logout"></s:url>'>here</a> to logout.	
</p>