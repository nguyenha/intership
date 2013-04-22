<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="codesList.title"/></title>
    <meta name="heading" content="<fmt:message key='codesList.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<%-- 
<div class="buttons" style="float:left;padding-right:15px;margin-top: 20px;">
 	<form:form commandName="codeTypeSearch" method="post" action="codeTypeList.html">
		<fieldset class="ui-widget ui-widget-content" style="width: 100%;">
			<legend class="ui-widget-header ui-corner-all">
				<fmt:message key="codeType.searchForm" />
			</legend>
			<table>
				<tr>
					<td><appfuse:label styleClass="desc" key="codeType.txtSearch"/></td>
					<td><form:input path="name" /></td>
				</tr>
			</table>
			<button type="button" class="negative" id="searchForm_button_reset"  onclick="resetFields();">
				<fmt:message key="button.reset" />
			</button>
			<button type="submit" class="searchb" id="searchForm_button_search" name="search">
				<fmt:message key="button.search" />
			</button>
		</fieldset>
	</form:form>
</div><br/> --%>
<div class="cleaner"></div>

<display:table name="listData" cellspacing="0" cellpadding="0" defaultsort="1" id="codeData" pagesize="2" class="listing-tbl" export="true">
    <display:column property="code" sortable="true" escapeXml="true" titleKey="codesData.code" style="width: 15%" 
    	url="/admin/editCode" paramId="id" paramProperty="id"/>
	<display:column property="name" sortable="true" titleKey="codesData.name" style="width: 30%"/>
	<display:column property="codeType.name" sortable="true" titleKey="codesData.codeType" style="width: 15%"/>
	<display:column property="description" sortable="true" titleKey="codeTypeData.description" style="width: 40%"/>
    
    <display:setProperty name="paging.banner.item_name" value="codeData"/>
    <display:setProperty name="paging.banner.items_name" value="codeList"/>

    <display:setProperty name="export.excel.filename" value="Code List.xls"/>
    <display:setProperty name="export.csv.filename" value="Code List.csv"/>
    <display:setProperty name="export.pdf.filename" value="Code List.pdf"/>
</display:table>

<span id="toolbar" class="ui-corner-all">
	<button type="button" style="margin-right: 5px" id="addCode" onclick="location.href='<c:url value="/admin/editCode"/>'">
        <fmt:message key="button.add" />
    </button>

    <button type="button" id="doneVessel" onclick="location.href='<c:url value="/admin"/>'">
        <fmt:message key="button.done" />
    </button>
</span>
