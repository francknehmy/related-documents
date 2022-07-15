package com.webbfontaine.related.sad

import com.webbfontaine.related.sad.command.SearchCommand
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Slf4j

@Slf4j("LOGGER")
@Transactional(readOnly = true)
@Secured(['IS_AUTHENTICATED_FULLY'])
class SadController {

    def sadSearchService

    def index() {
        redirect action: 'list'
    }

    def list(SearchCommand searchCommand) {
        [searchCommand: searchCommand]
    }

    def search(SearchCommand searchCommand) {

        Map searchResultModel = sadSearchService.getSearchResults(searchCommand, params)
        flash.searchResultMessage = searchResultModel.searchResultMessage

        if (request.isXhr()) {
            render(plugin: 'wf-search', template: '/searchResult', model: searchResultModel)
        } else {
            render(view: 'list', model: searchResultModel)
        }
    }

    def show() {
        LOGGER.debug("in show() of ${SadController}")
        if (params?.officeCode && params?.id) {
            [params : params]
        } else {
            notFound()
        }
    }

    protected void notFound() {
        flash.message = message(code: 'default.not.found.message', args: [message(code: 'sad.label', default: 'sad'), params.id])
        redirect action: "index", method: "GET"
    }
}
