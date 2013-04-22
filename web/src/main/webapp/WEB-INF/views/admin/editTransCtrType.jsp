<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="transCtrTypeForm.title"/></title>
    <meta name="heading" content="<fmt:message key='transCtrTypeForm.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<%-- commandName="transCtrType" --%>
<form:form modelAttribute="editData" method="post" action="${ctx }/admin/editTransCtrType" id="transCtrTypeForm">
	<form:hidden path="id" />
	<form:errors path="*" />
	<table>
		<tr>
			<td><fmt:message key="transCtrTypeData.code" /></td>
			<td> 
				<form:input path="code" id="countryCode" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="code" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="transCtrTypeData.name" /></td>
			<td> 
				<form:input path="name" id="transCtrTypeName" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="name" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="transCtrTypeData.description" /></td>
			<td> 
				<form:textarea path="description" id="transCtrTypeDataDescription" cssClass="text large" cssErrorClass="text large error" />
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
