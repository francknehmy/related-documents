package com.webbfontaine.related.sad.security

import groovy.transform.CompileStatic

/**
 * Copyrights 2002-2018 Webb Fontaine
 * Developer: Peter Arvin Bulong
 * Date: 2/14/2018
 * This software is the proprietary information of Webb Fontaine.
 * Its use is subject to License terms.
 */
@CompileStatic
final class Roles {
    static String ROLE_SW_VIEWER_ADMIN = 'ESAD_ADMIN'
    static String ROLE_SW_VIEWER_SUPERVISOR = 'ESAD_SUPERVISOR'
    static String ROLE_SW_VIEWER_DECLARANT = 'ESAD_DECLARANT'
    static String ROLE_SW_VIEWER_TRADER = 'ESAD_TRADER'

    static final String ROLE_BP_TRADER = 'BP_TRADER'
    static final String ROLE_BP_DECLARANT= 'BP_DECLARANT'
    static final String ROLE_BP_GOV_CHIEF= 'BP_GOVCHIEF'
    static final String ROLE_BP_ADMIN= 'BP_ADMIN'
    static final String ROLE_BP_SUPER_ADMIN= 'BP_SUPER_ADMIN'
    static final String ROLE_BP_GOV_OFFICER= 'BP_GOVOFFICER'
    static final String ROLE_BP_GOV_SENIOR_OFFICER = 'BP_GOVSROFFICER'
    static final String ROLE_BP_GOV_SUPERVISOR_OFFICER= 'BP_GOVSUPERVISOR_OFFICER'
}

