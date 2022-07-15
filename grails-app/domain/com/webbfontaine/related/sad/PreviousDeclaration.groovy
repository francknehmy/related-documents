package com.webbfontaine.related.sad

import com.webbfontaine.grails.plugins.taglibs.ConfigurableFields
import org.joda.time.LocalDate

class PreviousDeclaration implements ConfigurableFields {
   // Integer itemNo // ART
    Integer rank // KEY_INT_NBR

    Integer previousDocumentReferenceYear // DEC_REF_YER
    String officeCode // IDE_CUO_COD
  //  String officeName // IDE_CUO_NAM
    String customsReferenceSerial // IDE_REG_SER
    String customsReference // IDE_REG_NBR
    Integer customsReferenceItem // TAR_HSC_ART
    LocalDate customsRegistrationDatePrevDoc // IDE_REG_DAT

    String warehouseCodeInit // WHS_COD
    String regimeInitVal // TAR_PRC_EXT
    String productInitVal // TAR_HSC_NB1
    String productInitPrecision // TAR_HSC_NB2
    String countryOfOriginInitVal // GDS_ORG_CTY
    BigDecimal referenceCifInitVal // VIT_CIFU
    LocalDate expirationDateInitVal // WHS_TIM

    BigDecimal packageNumberInitVal // PCK_NBRI
    BigDecimal packageNumberCurrVal // PCK_NBR
    BigDecimal netMassInitVal // VIT_WGT_NETI
    BigDecimal netMassCurrVal // VIT_WGT_NET
    BigDecimal suppUnitsInitVal // TAR_SUP_QTYI
    BigDecimal suppUnitsCurrVal // TAR_SUP_QTY

    String warehouseCodeThisItem
    String regimeThisItem
    String productThisItem
    String productPrecisionThisItem
    String countryOfOriginThisItem
    BigDecimal referenceCifThisItem
    LocalDate expirationDateThisItem

    BigDecimal packageNumberThisItem
    BigDecimal netMassThisItem
    BigDecimal suppUnitsThisItem

    BigDecimal writeOffPackageNbr
    BigDecimal writeOffNetmass
    BigDecimal writeOffSupUnits

    static transients = ['warehouseCodeThisItem', 'regimeThisItem', 'productThisItem', 'productPrecisionThisItem', 'countryOfOriginThisItem', 'referenceCifThisItem', 'expirationDateThisItem', 'packageNumberThisItem', 'netMassThisItem', 'suppUnitsThisItem']
    static belongsTo = [sad: Sad]

    static constraints = {
        sad nullable: false
    }

    static mapping = {
        table 'SAD_INT_VW'
        version false
        id column: 'INSTANCE_ID'
      //  itemNo column: 'ART'
        rank column: 'KEY_INT_NBR'
        previousDocumentReferenceYear column: 'DEC_REF_YER'
        officeCode column: 'IDE_CUO_COD', length: 5
       // officeName column: 'IDE_CUO_NAM', length: 35
        customsReferenceSerial column: 'IDE_REG_SER', length: 1
        customsReference column: 'IDE_REG_NBR'
        customsReferenceItem column: 'TAR_HSC_ART'
        customsRegistrationDatePrevDoc column: 'IDE_REG_DAT'
        warehouseCodeInit column: 'WHS_COD'
        regimeInitVal column: 'TAR_PRC_EXT'
        productInitVal column: 'TAR_HSC_NB1', length: 9
        productInitPrecision column: 'TAR_HSC_NB2', length: 3
        countryOfOriginInitVal column: 'GDS_ORG_CTY', length: 3
        referenceCifInitVal column: 'VAL_CUR'
        expirationDateInitVal column: 'EXP_DAT'
        packageNumberInitVal column: 'PCK_NBRI'
        packageNumberCurrVal column: 'PCP_NBR'
        netMassInitVal column: 'VIT_WGT_NETI'
        netMassCurrVal column: 'VIT_WGT_NET'
        suppUnitsInitVal column: 'TAR_SUP_QTYI'
        suppUnitsCurrVal column: 'TAR_SUP_QTY'
        writeOffPackageNbr column: 'WRT_PCK_NBR'
        writeOffNetmass column: 'WRT_WGT_NET'
        writeOffSupUnits column: 'WRT_SUP_QTY'
    }

    @Override
    boolean isFieldMandatory(String fieldName) {
        return false
    }

    @Override
    boolean isFieldEditable(String fieldName) {
        return false
    }

    String getProductInitVal(){
        "$productInitVal$productInitPrecision"
    }
}
