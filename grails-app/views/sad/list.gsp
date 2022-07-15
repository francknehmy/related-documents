<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="page">
    <g:set var="entityName" value="${message(code: 'sad.label', default: 'Sad')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<wf:ajaxProgress/>
<content tag="application">
    <layout:pageResources dependsOn="application">
        <wf:tagLibSetup locale="${request.locale}"/>
        <layout:resource name="searchUtils" plugin="wf-search" dependsOn="application.js"/>
        <layout:resource name="${message(code: 'i18messages')}"/>
    </layout:pageResources>
    <h3 id="title"><g:message code="search.sad.label" default="Search Sad"/></h3>
    <wf:searchForm name="searchForm" action="search" method="get" model="[searchCommand: searchCommand]" template="/sad/search/searchCriteria"/>
    <bootstrap:div id="searchResults">
        <g:render plugin="wf-search" template="/searchResult"
                  model="[searchCommand : searchCommand,
                          max           : max,
                          resultList    : resultList,
                          totalCount    : totalCount]"/>
    </bootstrap:div>
</content>
</body>
</html>
