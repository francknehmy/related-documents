package com.webbfontaine.related.sad

import com.webbfontaine.grails.plugins.taglibs.ConfigurableFields
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Container implements Serializable, ConfigurableFields {

    Integer rank
    Integer containerItemNumber
    String containerReference
    String containerTypeCode
    String sealNumber1
    String mark1
    String mark2
    String emptyFullIndicatorCode
    Integer numberOfPackages
    String packagingTypeCode
    String goods
    String emptyWeight
    String goodsWeight

    static belongsTo = [item: Item]

    static constraints = {
        rank nullable: true
        containerReference nullable: true
        containerTypeCode nullable: true
        sealNumber1 nullable: true
        mark1 nullable: true
        mark2 nullable: true
        emptyFullIndicatorCode nullable: true
        numberOfPackages nullable: true
        packagingTypeCode nullable: true
    }

    static mapping = {
        version false
        table 'SAD_CONTAINERS_VW'
        id column: 'INSTANCE_ID'
        item column: 'ITEM_ID'
        rank column: 'KEY_RNK'
        containerItemNumber column: 'ITM_NBR'
        containerReference column: 'IDT', length: 17                    // REF, length: 17
        containerTypeCode column: 'TYP', length: 4                      // TYP, length:4
        sealNumber1 column: 'SEA3', length: 20                           // SEA, length:20
        mark1 column: 'SEA1', length: 10                                 // MK1, length:10
        mark2 column: 'SEA2', length: 10                                 // MK2, length:10
        emptyFullIndicatorCode column: 'FUL', length: 4                 // FUL, length: 3
        numberOfPackages column: 'PKG_NBR', length: 10                  // PCK_NBR, length:10
        packagingTypeCode column: 'PKG_TYP', length: 17                 // PCK_TYP, length:17
        goods column: 'GDS'
        emptyWeight column: 'WTC'
        goodsWeight column: 'PKG_WGT'
        /*
        description column: 'DSC', length: 300             */            // DSC, length:300
    }


    @Override
    boolean isFieldMandatory(String fieldName) {
       false
    }

    @Override
    boolean isFieldEditable(String fieldName) {
       false
    }
}