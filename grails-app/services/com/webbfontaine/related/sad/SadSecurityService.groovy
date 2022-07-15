package com.webbfontaine.related.sad


import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService


@Transactional
class SadSecurityService {

    SpringSecurityService springSecurityService

    def getUsername(){
        principal.username
    }


    private getPrincipal(){
        return springSecurityService.principal
    }


}
