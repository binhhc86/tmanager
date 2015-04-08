<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="customerList.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="customerList.heading"/></h2>

    <form method="get" action="${ctx}/admin/customers" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm">
        </span>
        <button id="button.search" class="btn btn-default btn-sm" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/customerform?method=Add&from=list'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="customerList" cellspacing="0" cellpadding="0" requestURI=""
                   defaultsort="1" id="customers" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
        <display:column property="firstname" escapeXml="true" sortable="true" titleKey="customer.firstname" style="width: 25%"
                        url="/customerform?from=list" paramId="id" paramProperty="id"/>
        <display:column property="lastname" escapeXml="true" sortable="true" titleKey="customer.lastname"
                        style="width: 34%"/>
        <display:column property="address" sortable="true" titleKey="customer.address" style="width: 25%" autolink="true"
                        media="html"/>
        
        <display:setProperty name="paging.banner.item_name"><fmt:message key="customerList.customer"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="customerList.customers"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Customer List.xls"/>
        <display:setProperty name="export.csv.filename" value="Customer List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Customer List.pdf"/>
    </display:table>
</div>
