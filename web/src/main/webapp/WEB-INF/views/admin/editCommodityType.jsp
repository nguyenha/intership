<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="commodityTypeForm.title"/></title>
    <meta name="heading" content="<fmt:message key='commodityTypeForm.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<%-- commandName="commodityType" --%>
<form:form modelAttribute="editData" method="post" action="${ctx }/admin/editCommodityType" id="commodityTypeForm">
	<form:hidden path="id" />
	<form:errors path="*" />
	<table>
		<tr>
			<td><fmt:message key="commodityTypeData.code" /></td>
			<td> 
				<form:input path="code" id="countryCode" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="code" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="commodityTypeData.name" /></td>
			<td> 
				<form:input path="name" id="commodityTypeName" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="name" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="commodityTypeData.description" /></td>
			<td> 
				<form:textarea path="description" id="commodityTypeDataDescription" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="description" cssClass="fieldError" />
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
