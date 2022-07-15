package com.webbfontaine.related.sad

import com.webbfontaine.related.sad.constants.RelatedConstants
import com.webbfontaine.related.sad.rest.Command
import grails.converters.JSON
import groovy.util.logging.Slf4j
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

import java.text.SimpleDateFormat

@Slf4j("LOGGER")
class RelatedDocumentsController {
    RelatedDocumentService relatedDocumentService

    def retrieveTimber() {
        LOGGER.debug("Entre ici")
        Command command = new Command()
        command?.setClearanceOfficeCode(params?.clearanceOfficeCode)
        command?.setDeclarationSerial(params?.clearanceDeclarationSerial)
        command?.setDeclarationNumber(Integer.parseInt(params?.clearanceDeclarationNumber))
        command?.setDeclarationDate(new SimpleDateFormat("dd/MM/yyyy").format(new LocalDate(params?.clearanceDeclarationDate).toDate()))

        def result = relatedDocumentService.processRelatedDocument(RelatedConstants.TIMBER, command)
        def responseModel = [template: g.render(template: '/sad/templates/result/timber', model: [resultList: result,
        appName : RelatedConstants.TIMBER])]
        render responseModel as JSON
    }
}
