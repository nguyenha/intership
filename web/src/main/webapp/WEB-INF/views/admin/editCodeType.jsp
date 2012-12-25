<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="codeTypeForm.title"/></title>
    <meta name="heading" content="<fmt:message key='codeTypeForm.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<%-- commandName="codeType" --%>
<form:form modelAttribute="editData" method="post" action="${ctx }/admin/editCodeType" id="codeTypeForm">
	<form:hidden path="id" />
	<form:errors path="*" />
	<table>
		<tr>
			<td><fmt:message key="codeTypeData.code" /></td>
			<td> 
				<form:input path="code" id="countryCode" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="code" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="codeTypeData.name" /></td>
			<td> 
				<form:input path="name" id="codeTypeName" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="name" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="button"><fmt:message key="button.save" /></button>
				<button type="reset" class="button"><fmt:message key="button.cancel" /></button>
			</td>
		</tr>
	</table>

</form:form>
