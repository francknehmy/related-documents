<bootstrap:form name="searchSadForm" class="search sad-search-criteria" method="post"
                url="[action: 'search', controller: 'sad']" labelPrefix="sad.search"
                grid="5(6-5)-7(3-3)">
    <bootstrap:formSection>
        <bootstrap:formGroup groupSpan="12" labelSpan="2" labelCode="reference.sad.label"  >
            <bootstrap:formInput span="2">
                <wf:textInput name="officeOfDispatchExportCode" value="${searchCommand?.officeOfDispatchExportCode}" class="span2 wfsearchinput"/>
            </bootstrap:formInput>
            <bootstrap:formInput span="1">
                <wf:textInputInUppercase name="customsRegistrationSerial" placeholder="${message(code: 'sad.serial.label')}"
                                         value="${searchCommand?.customsRegistrationSerial}"
                                         regexp="${"[a-zA-Z0-9]"}" maxlength="1"/>
            </bootstrap:formInput>
            <bootstrap:formInput span="1">
                <wf:textInput name="customsRegistrationNumber" regexp="${"[0-9]"}"
                              maxlength="10" placeholder="${message(code: 'sad.number.label')}"
                              value="${searchCommand?.customsRegistrationNumber}"/>
            </bootstrap:formInput>
            <bootstrap:formInput span="2">
                <wf:datepicker name="customsRegistrationDate" placeholder="${message(code: 'related.declaration.date.label')}"  value="${searchCommand?.customsRegistrationDate}" />
            </bootstrap:formInput>
        </bootstrap:formGroup>
    </bootstrap:formSection>
    <wf:searchButtons/>
</bootstrap:form>
