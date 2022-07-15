package com.webbfontaine.related.sad


import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ItemTax extends com.webbfontaine.related.sad.model.BaseTax implements Serializable {

    Long sadId
    Integer itemNumber
    static transients = ['initAmount', 'description']

    static belongsTo = [item: Item]

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
/*        benCode nullable: true
        benName nullable: true*/
    }

    static mapping = {
        table 'SAD_TAX_VW'
        version false
        id composite: ['sadId', 'itemNumber', 'rank']
        sadId column: 'INSTANCE_ID'
        itemNumber column: 'KEY_ITM_NBR'
        item: column: 'ITEM_ID'
        rank column: 'KEY_TAX_RNK'
        code column: 'TAX_LIN_COD'
        baseAmount column: 'TAX_LIN_BSE'
        rate column: 'TAX_LIN_RAT'
        amount column: 'TAX_LIN_AMT'
        methodOfPayment column: 'TAX_LIN_MOP'
        type column: 'TAX_LIN_TYP'
     /*   benCode column: 'BEN_COD'
        benName column: 'BEN_NAM'*/
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.getClass()) return false

        ItemTax itemTax = (ItemTax) o

        if (code != itemTax.code) return false

        return true
    }

    int hashCode() {
        return (code != null ? code.hashCode() : 0)
    }

    @Override
    String toString() {
        return "ItemTax{} " + super.toString();
    }
}
