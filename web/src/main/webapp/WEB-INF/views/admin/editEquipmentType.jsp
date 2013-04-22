<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="equipmentTypeForm.title"/></title>
    <meta name="heading" content="<fmt:message key='equipmentTypeForm.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<%-- commandName="equipmentType" --%>
<form:form modelAttribute="editData" method="post" action="${ctx }/admin/editEquipmentType" id="equipmentTypeForm">
	<form:hidden path="id" />
	<form:errors path="*" />
	<table>
		<tr>
			<td><fmt:message key="equipmentTypeData.code" /></td>
			<td> 
				<form:input path="code" id="countryCode" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="code" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="equipmentTypeData.name" /></td>
			<td> 
				<form:input path="name" id="equipmentTypeName" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="name" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="equipmentTypeData.description" /></td>
			<td> 
				<form:textarea path="description" id="equipmentTypeDataDescription" cssClass="text large" cssErrorClass="text large error" />
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
