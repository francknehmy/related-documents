package com.webbfontaine.related.sad


import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class GlobalTax extends com.webbfontaine.related.sad.model.BaseTax implements Serializable {

    static transients = ['initAmount']

    static belongsTo = [sad: Sad]

    static constraints = {
        rank nullable: true
        code nullable: true
        description nullable: true
        amount nullable: true
        initAmount nullable: true
        baseAmount nullable: true
        rate nullable: true
        type nullable: true
        methodOfPayment nullable: true
      //  benCode nullable: true
      //  benName nullable: true
    }

    static mapping = {
        table 'SAD_GLOBAL_TAXES_VW'
        sad column: 'SAD_ID'
        id column: 'INSTANCE_ID'
        version false
        rank column: 'KEY_TAX_RNK'
        code column: 'TAX_COD', length: 3
        description column: 'TAX_DSC', length: 35
        baseAmount column: 'TAX_BSE'
        amount column: 'TAX_AMT'
        rate column: 'TAX_RAT'
        methodOfPayment column: 'TAX_MOP', length: 1
        type column: 'TAX_TYP', length: 1
     //   benCode column: 'BEN_COD'
      //  benName column: 'BEN_NAM'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.getClass()) return false

        GlobalTax globalTax = (GlobalTax) o

        if (code != globalTax.code) return false

        return true
    }

    int hashCode() {
        return (code != null ? code.hashCode() : 0)
    }

    @Override
    String toString() {
        return "GlobalTax{} " + super.toString();
    }
}
