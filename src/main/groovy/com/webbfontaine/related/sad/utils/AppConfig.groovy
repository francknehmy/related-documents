package com.webbfontaine.related.sad.utils

import grails.util.Holders

class AppConfig {
    static isRelatedDocumentEnabledFor(module) {
        return Holders.config.rest.relatedDocuments."${module}".enabled
    }

    static resolveRetrieveRelatedDocumentURL(module){
        return Holders.config.rest.relatedDocuments."${module}".url
    }
    static String getBasicUser() {
        Holders.config.com.webbfontaine.related.basicAuth.user
    }

    static String getBasicPassword() {
        Holders.config.com.webbfontaine.related.basicAuth.password
    }

}
