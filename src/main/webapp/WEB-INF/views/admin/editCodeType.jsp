<%@include file="/WEB-INF/common/taglibs.jsp"%>

<form:form commandName="codeType" method="post" action="/intership/admin/editCodeType" id="codeTypeForm">
	<form:hidden path="id" />
	<table>
		<tr>
			<td>Code</td>
			<td><form:errors path="code" cssClass="fieldError" /> 
				<form:input path="code" id="countryCode" cssClass="text large" cssErrorClass="text large error" /></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><form:errors path="name" cssClass="fieldError" /> 
				<form:input path="name" id="codeTypeName" cssClass="text large" cssErrorClass="text large error" />
				<button type="submit" class="button" name="save" value="<fmt:message key="button.save"/>" />
				<button type="reset" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" />
			</td>
		</tr>
	</table>

</form:form>
