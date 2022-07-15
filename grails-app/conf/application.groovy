grails.gorm.default.constraints = {
    '*'(nullable: true)
}

grails.gorm.default.mapping = {
    "user-type" type: org.jadira.usertype.dateandtime.joda.PersistentDateTime, class: org.joda.time.DateTime
    "user-type" type: org.jadira.usertype.dateandtime.joda.PersistentLocalDate, class: org.joda.time.LocalDate
    "user-type" type: org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime, class: org.joda.time.LocalDateTime
}

grails.databinding.dateFormats = ["dd/MM/yyyy", "yyyy-MM-dd"]
dateFormat = 'dd/MM/yyyy'
timeFormat = 'HH:mm:ss'
jodatime.format.html5 = true
jodatime.format.org.joda.time.LocalDate = dateFormat
jodatime.format.org.joda.time.DateTime = "${dateFormat} ${timeFormat}"
jodatime.format.org.joda.time.LocalDateTime = "${dateFormat} ${timeFormat}"
JQueryDateFormat = "dd/mm/yy"
bootstrapDate = 'DD/MM/YYYY'
decimalTranslationFormat = "#,##0.00"
defaultMaxPaginationItems = 10
wholeNumberRegex="\\b\\d+\\b"

rest{
    relatedDocuments {
        timber {
            enabled = true
            url = "http://localhost:8092/guce-ws/rest/export-authorizations"
        }
        forex {
            enabled = true
            url = "http://102.223.252.60:8685/guce-ws/rest/export-authorizations"
        }
    }
}

com{
    webbfontaine{
        related{
            basicAuth{
                user = "wf"
                password = "12345678"
            }
        }
    }
}
