package com.webbfontaine.related.sad.workflow

/**
 * Copyrights 2002-2016 Webb Fontaine
 * Developer: Peter Arvin Bulong
 * Date: 14/02/2018
 * This software is the proprietary information of Webb Fontaine.
 * Its use is subject to License terms.
 */
enum Role {
    ADMIN,SUPERVISOR,DECLARANT,TRADER,GOVCHIEF, GOVOFFICER, GOVSROFFICER, GOVSUPERVISOR_OFFICER,SUPER_ADMIN, BANK_AGENT

    String getAuthority(def type = null) {
        if(type){
            return "ROLE_" + getRoleBp()
        }else{
            return "ROLE_" + getRole()
        }
    }

    String getRoleBp() {
        return "BP_" + name()
    }


    String getRole() {
        return "SW_ESAD_" + name()
    }
}