<g:link action="show" params="${[id: domainInstance?.id, officeCode : domainInstance?.officeOfDispatchExportCode,
        declarationSerial : domainInstance?.customsRegistrationSerial, declarationNumber : domainInstance?.customsRegistrationNumber,
                                 declarationDate : domainInstance?.customsRegistrationDate,
]}" title="${message(code: 'related.show.sad', default: 'Show Sad')}"> <i class="glyphicon glyphicon-eye-open"></i></g:link>


