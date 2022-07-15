package com.webbfontaine.related.sad

import org.joda.time.LocalDate

class Sad implements Serializable {
    String officeOfDispatchExportCode //IDE_CUO_COD
    String exporterCode // CMP_EXP_COD
    String consigneeCode // CMP_CON_COD
    String declarantCode // DEC_COD
    String customsRegistrationNumber // IDE_REG_NBR
    String customsRegistrationSerial // IDE_REG_SER
    LocalDate customsRegistrationDate // IDE_REG_DAT
    String status


    static hasMany = [items: Item, globalTaxes: GlobalTax, previousDeclarations: PreviousDeclaration]


    static mapping = {
        version false
        table 'SAD_GENERAL_SEGMENT_VW'

        id column: 'INSTANCEID'
        officeOfDispatchExportCode column: 'IDE_CUO_COD', length: 5
        exporterCode column: 'CMP_EXP_COD', length: 17
        consigneeCode column: 'CMP_CON_COD', length: 17
        declarantCode column: 'DEC_COD', length: 17
        customsRegistrationNumber column: 'IDE_REG_NBR', length: 50
        customsRegistrationSerial column: 'IDE_REG_SER', length: 1
        customsRegistrationDate column: 'IDE_REG_DAT'
    }

}
