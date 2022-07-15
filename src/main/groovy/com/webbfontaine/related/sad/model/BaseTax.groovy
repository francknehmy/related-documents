package com.webbfontaine.related.sad.model

import com.webbfontaine.grails.plugins.taxation.data.Tax
import groovy.transform.CompileStatic

/**
 * Copyrights 2002-2018 Webb Fontaine
 * Developer: Peter Arvin Bulong
 * Date: 2/22/2018
 * This software is the proprietary information of Webb Fontaine.
 * Its use is subject to License terms.
 */
@CompileStatic
abstract class BaseTax implements Tax {

    public static final String MANUAL_TAX_TYPE = 'M'

    public static final String MANUAL_TAX_DEFAULT_MOP = '1'

    public static final String FREE_TAX_CODE = "???"

    Integer rank
    String code
    String description
    BigDecimal amount = BigDecimal.ZERO
    BigDecimal initAmount
    BigDecimal baseAmount
    BigDecimal rate
    String type
    String methodOfPayment
   /* String benCode
    String benName*/

    boolean isManualTax() {
        return type == MANUAL_TAX_TYPE
    }

    @Override
    String toString() {
        return "BaseTax{" +
                "rank=" + rank +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", baseAmount=" + baseAmount +
                ", rate=" + rate +
                ", type='" + type + '\'' +
                ", methodOfPayment='" + methodOfPayment + '\'' +
                "} "
    }
}
