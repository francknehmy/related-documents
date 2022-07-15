<%@ page import="com.webbfontaine.related.sad.common.BusinessLogicUtils; org.springframework.context.i18n.LocaleContextHolder" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="page"/>
</head>

<body>
<content tag="application">
    <div class="aboveFormLabel">
        <h3>
            <g:message code="related.show.sad" default="View Related Documents"/>
            <label class="label editTitle label-success">
            ${BusinessLogicUtils.buildSadReference(params?.officeCode, params?.declarationSerial, params?.declarationNumber, params?.declarationDate)}
            </label>
        </h3>
    </div>
    <bootstrap:div id="formContents">

        <layout:pageResources dependsOn="application">
            <wfConversation:conversationSetup conversationId="${params.conversationId}"/>
            <wf:tagLibSetup locale="${request.locale}" validation="all"/>
            <layout:resource
                    name="${asset.i18nPath([name: 'messages', locale: LocaleContextHolder.locale])}"
                    skipCheck="${true}"/>
            <wf:tagLibSetup locale="${request.locale}" validation="all"/>
        </layout:pageResources>
        <bootstrap:form name="appMainForm" class="form-hoprizontal">
            <bootstrap:div>
                <g:render template="/common/templates/operations"/>
            </bootstrap:div>
            <bootstrap:tab name="related" type="flat">
                <g:render template="templates/tabs" />
                <g:render template="/utils/setUp" />
                <g:render template="/utils/hiddenField" />
            </bootstrap:tab>
        </bootstrap:form>
    </bootstrap:div>
</content>

</body>
</html>
