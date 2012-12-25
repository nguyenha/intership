<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="codeTypeForm.title"/></title>
    <meta name="heading" content="<fmt:message key='codeTypeForm.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<%-- commandName="codeType" --%>
<form:form modelAttribute="editData" method="post" action="${ctx }/admin/editCode" id="codeForm">
	<form:hidden path="id" />
	<form:errors path="*" />
	<table>
		<tr>
			<td><fmt:message key="codesData.codeType" /></td>
			<td>
				<form:select path="codeType" itemLabel="name" itemValue="id" items="${codeTypes }"></form:select>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="codesData.code" /></td>
			<td> 
				<form:input path="code" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="code" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="codesData.name" /></td>
			<td> 
				<form:input path="name" cssClass="text large" cssErrorClass="text large error" />
				<form:errors path="name" cssClass="fieldError" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="codesData.desc" /></td>
			<td> 
				<form:input path="description" cssClass="text large" cssErrorClass="text large error" />
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
