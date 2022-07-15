package com.webbfontaine.related.sad

import com.webbfontaine.grails.plugins.taglibs.ConfigurableFields
import org.grails.datastore.gorm.GormValidateable
import org.grails.datastore.gorm.finders.DynamicFinder
import org.joda.time.LocalDate


class Item implements ConfigurableFields, Serializable, GormValidateable {

    static final int COM_CODE_NAT_PREC2_SIZE = 2

    Integer rank // KEY_ITM_NBR

    // Package
    Integer packageNumber // PCK_NBR                            | numberOfPackages
    String packageMark1 // PCK_MRK1                                | marks1
    String packageMark2 // PCK_MRK2                                | marks2
    String itemPackageTypeCode //  PCK_TYP_COD                     | typeOfPackagesCode
    String itemPackageTypeName // PCK_TYP_NAM                      | typeOfPackagesName

    // Tariff
    String commodityCode                       // TAR_HSC_NB1
    String commodityCodeNationalPrecision2     // TAR_HSC_NB2      | commodityCodePrecision2
    String commodityCodeNationalPrecision3     // TAR_HSC_NB3      | commodityCodePrecision3
    String commodityCodeNationalPrecision4     // TAR_HSC_NB4      | -------
    String specificationCode                   // TAR_HSC_NB5      | specification code

    //  String specificationName                   // TAR_HSC_NB5_NAM  | specification description

    // Tariff Specification
    LocalDate tariffSpecificationCodeDate // TAR_HSC_TSC_DAT
    String tariffSpecificationStatus // TAR_HSC_TSC_STA
    String tariffPreferenceCode // TAR_PRF                         | preferenceCode
    // String tariffPreferenceName // TAR_PRF
    // Procedure

    String extendedProcedureCode // TAR_PRC_EXT                    | extendedCustomsProcedureCode
    String nationalProcedureCode // TAR_PRC_NAT                    | nationalCustomsProcedureCode

    // Item Price
    BigDecimal price // TAR_PRI
    String valuationMethodCode // TAR_VMT
    String quota // TAR_QUO
    String valuationDetails // TAR_VDT
    String itemAttachedDocuments // TAR_ATT
    String additionalInformationCode // TAR_AIC

    // Goods Description
    String itemCountryOfOriginCode // GDS_ORG_CTY
    String countryOfOriginRegionCode // GDS_ORG_CRG
    // Goods Container
    String container1 // GDS_CTN_CT1
    String container2 // GDS_CTN_CT2
    String container3 // GDS_CTN_CT3
    String container4 // GDS_CTN_CT4

    String commodityDescription // GDS_DSC
    String commercialDescription // GDS_DS3

    // Links with other documents/entities
    String linkOfTransportDocument // LNK_TPT
    String linkOfTransportDocumentSubLine // LNK_TPT_SLN
    String previousDocumentReference // LNK_PRV_DOC
    String additionalWarehouseCode // LNK_PRV_WHS
    String additionalInformation // TXT_FRE
    String processingPrograms // TXT_RSV
    //  String processingProgramsProductCode
    // String processingProgramsProductName

    // License Information
    String licenseReferenceCode // LIC_COD
    BigDecimal deductedLicenseValueAmount // LIC_AMT_VAL
    BigDecimal deductedLicenseQuantity // LIC_AMT_QTY

    // Taxation
    BigDecimal dutiesAndTaxesAmount // TAX_AMT
    BigDecimal guaranteedAmount // TAX_GTY
    String modeOfPayment // TAX_MOP
    BigDecimal displayedAmount // TAX_DTY

    // Valuation Item
    BigDecimal itemGrossMass // VIT_WGT_GRS
    BigDecimal netMass // VIT_WGT_NET

    BigDecimal supplementaryAmount // TAR_SUP_QTY

     BigDecimal supplementaryAmount1

     BigDecimal supplementaryAmount2

     String supplementaryCode // TAR_SUP_COD

     String supplementaryCode1

     String supplementaryCode2
     String supplementaryName // TAR_SUP_NAM
     String supplementaryName1
     String supplementaryName2

    /* String warehouseUnitOfMeasurementCode

     String warehouseUnitOfMeasurementName

     BigDecimal warehouseUnitOfMeasurementQuantity*/

    BigDecimal addedCostsAmount // VIT_CST

    BigDecimal costInsuranceFreightAmount // VIT_CIF

    BigDecimal adjustmentRate = BigDecimal.ONE // VIT_ADJ
    BigDecimal alphaCoefficientOfApportionment // VIT_ALP

    BigDecimal statisticalValue // VIT_STV

    // Invoice Amount and Currency

    BigDecimal itemInvoiceAmountInNationalCurrency // VIT_INV_AMT_NMU

    BigDecimal itemInvoiceAmountInForeignCurrency // VIT_INV_AMT_FCX

    String itemInvoiceCurrencyCode // VIT_INV_CUR_COD

    String itemInvoiceCurrencyName // VIT_INV_CUR_NAM

    BigDecimal itemInvoiceCurrencyExchangeRate // VIT_INV_CUR_RAT

    BigDecimal itemInvoiceCurrencyReferenceUnit // VIT_INV_CUR_REF

    // External Freight Amount and Currency
    BigDecimal itemExternalFreightAmountInNationalCurrency // VIT_EFR_AMT_NMU

    BigDecimal itemExternalFreightAmountInForeignCurrency // VIT_EFR_AMT_FCX

    String itemExternalFreightCurrencyCode // VIT_EFR_CUR_COD

    String itemExternalFreightCurrencyName // VIT_EFR_CUR_NAM

    BigDecimal itemExternalFreightCurrencyExchangeRate // VIT_EFR_CUR_RAT

    BigDecimal itemExternalFreightCurrencyReferenceUnit // VIT_EFR_CUR_REF

    // Internal Freight
    BigDecimal itemInternalFreightAmountInNationalCurrency // VIT_IFR_AMT_NMU

    BigDecimal itemInternalFreightAmountInForeignCurrency // VIT_IFR_AMT_FCX

    String itemInternalFreightCurrencyCode // VIT_IFR_CUR_COD

    String itemInternalFreightCurrencyName // VIT_IFR_CUR_NAM

    BigDecimal itemInternalFreightCurrencyExchangeRate // VIT_IFR_CUR_RAT

    BigDecimal itemInternalFreightCurrencyReferenceUnit // VIT_IFR_CUR_REF

    // Insurance
    BigDecimal itemInsuranceAmountInNationalCurrency // VIT_INS_AMT_NMU

    BigDecimal itemInsuranceAmountInForeignCurrency // VIT_INS_AMT_FCX

    String itemInsuranceCurrencyCode // VIT_INS_CUR_COD

    String itemInsuranceCurrencyName // VIT_INS_CUR_NAM

    BigDecimal itemInsuranceCurrencyExchangeRate // VIT_INS_CUR_RAT

    BigDecimal itemInsuranceCurrencyReferenceUnit // VIT_INS_CUR_REF

    // Other Costs
    BigDecimal itemOtherCostsAmountInNationalCurrency // VIT_OTC_AMT_NMU

    BigDecimal itemOtherCostsAmountInForeignCurrency // VIT_OTC_AMT_FCX

    String itemOtherCostsCurrencyCode // VIT_OTC_CUR_COD

    String itemOtherCostsCurrencyName // VIT_OTC_CUR_NAM

    BigDecimal itemOtherCostsCurrencyExchangeRate // VIT_OTC_CUR_RAT

    BigDecimal itemOtherCostsCurrencyReferenceUnit // VIT_OTC_CUR_REF

    // Deductions
    BigDecimal itemDeductionsAmountInNationalCurrency // VIT_DED_AMT_NMU

    BigDecimal itemDeductionsAmountInForeignCurrency // VIT_DED_AMT_FCX

    String itemDeductionsCurrencyCode // VIT_DED_CUR_COD

    String itemDeductionsCurrencyName // VIT_DED_CUR_NAM

    BigDecimal itemDeductionsCurrencyExchangeRate // VIT_DED_CUR_RAT

    BigDecimal itemDeductionsCurrencyReferenceUnit // VIT_DED_CUR_REF

    // Market Value
    BigDecimal marketValueAmount // VIT_MKT_AMT
    BigDecimal marketValueRate // VIT_MKT_RAT
    String marketValueCurrencyCode // VIT_MKT_CUR
    String marketValueBasisDescription // VIT_MKT_BSE_DSC
    BigDecimal marketValueBasisAmount // VIT_MKT_BSE_AMT

    // Blackbook
    String vinNumber // BLK_VIN
    BigDecimal salePrice // BLK_SRP
    BigDecimal freeOnBoardPrice // BLK_FOB

    String tempProcessingPrograms
    // Association
    static belongsTo = [sad: Sad]
    static hasMany = [itemTaxes: ItemTax, containers: Container, attachedDocuments: AttachedDocument, supplementaryUnits: SupplementaryUnit]

    static transients = ['supplementaryAmount', 'supplementaryAmount1', 'supplementaryAmount2', 'supplementaryCode', 'supplementaryCode1', 'supplementaryCode2', 'supplementaryName', 'supplementaryName1', 'supplementaryName2', 'tempProcessingPrograms']
    static constraints = {
        packageMark1 size: 1..35, nullable: true
        packageMark2 size: 1..35, nullable: true
        itemPackageTypeCode size: 1..17, nullable: true
        packageNumber range: 0..99999, nullable: true
        itemPackageTypeName size: 1..35, nullable: true
        commodityCode size: 1..8, nullable: true
        commodityCodeNationalPrecision2 size: 1..COM_CODE_NAT_PREC2_SIZE, nullable: true
        commodityCodeNationalPrecision3 size: 1..4, nullable: true
        commodityCodeNationalPrecision4 size: 1..4, nullable: true
        specificationCode size: 1..17, nullable: true
        tariffSpecificationStatus size: 1..1, nullable: true
        tariffPreferenceCode size: 1..8, nullable: true
        extendedProcedureCode size: 1..4, nullable: true
        nationalProcedureCode size: 1..3, nullable: true
        valuationMethodCode size: 1..1, nullable: true
        quota size: 1..5, nullable: true
        valuationDetails size: 1..75, nullable: true
        itemAttachedDocuments size: 1..55, nullable: true
        additionalInformationCode size: 1..3, nullable: true
        itemCountryOfOriginCode size: 2..2, nullable: true
        countryOfOriginRegionCode size: 1..4, nullable: true
        container1 size: 1..17, nullable: true
        container2 size: 1..17, nullable: true
        container3 size: 1..17, nullable: true
        container4 size: 1..17, nullable: true
        commercialDescription size: 1..88, nullable: true
        linkOfTransportDocument size: 1..85, nullable: true
        linkOfTransportDocumentSubLine size: 1..4, nullable: true
        previousDocumentReference size: 1..35, nullable: true
        additionalWarehouseCode size: 1..17, nullable: true
        additionalInformation size: 1..35, nullable: true
        licenseReferenceCode size: 1..17, nullable: true
        modeOfPayment size: 1..1, nullable: true
        itemInvoiceCurrencyCode size: 1..3, nullable: true
        itemInvoiceCurrencyName size: 1..35, nullable: true

        itemExternalFreightCurrencyCode size: 1..3, nullable: true
        itemExternalFreightCurrencyName size: 1..35, nullable: true

        itemInternalFreightCurrencyCode size: 1..3, nullable: true
        itemInternalFreightCurrencyName size: 1..35, nullable: true

        itemInsuranceCurrencyCode size: 1..3, nullable: true
        itemInsuranceCurrencyName size: 1..35, nullable: true

        itemOtherCostsCurrencyCode size: 1..3, nullable: true
        itemOtherCostsCurrencyName size: 1..35, nullable: true

        itemDeductionsCurrencyCode size: 1..3, nullable: true
        itemDeductionsCurrencyName size: 1..35, nullable: true

        marketValueCurrencyCode size: 1..3, nullable: true
        marketValueBasisDescription size: 1..35, nullable: true

        vinNumber size: 1..17, nullable: true

        rank nullable: true
        tariffSpecificationCodeDate nullable: true
        price nullable: true
        commodityDescription nullable: true
        processingPrograms nullable: true
        //     processingProgramsProductCode nullable: true
        //     processingProgramsProductName nullable: true
        deductedLicenseValueAmount nullable: true
        deductedLicenseQuantity nullable: true
        dutiesAndTaxesAmount nullable: true
        guaranteedAmount nullable: true
        displayedAmount nullable: true
        itemGrossMass nullable: true
        netMass nullable: true
        addedCostsAmount nullable: true
        costInsuranceFreightAmount nullable: true
        adjustmentRate nullable: true
        alphaCoefficientOfApportionment nullable: true
        statisticalValue nullable: true
        itemInvoiceAmountInNationalCurrency nullable: true
        itemInvoiceAmountInForeignCurrency nullable: true
        itemInvoiceCurrencyExchangeRate nullable: true
        itemInvoiceCurrencyReferenceUnit nullable: true
        itemExternalFreightAmountInNationalCurrency nullable: true
        itemExternalFreightAmountInForeignCurrency nullable: true
        itemExternalFreightCurrencyExchangeRate nullable: true
        itemExternalFreightCurrencyReferenceUnit nullable: true
        itemInternalFreightAmountInNationalCurrency nullable: true
        itemInternalFreightAmountInForeignCurrency nullable: true
        itemInternalFreightCurrencyExchangeRate nullable: true
        itemInternalFreightCurrencyReferenceUnit nullable: true
        itemInsuranceAmountInNationalCurrency nullable: true
        itemInsuranceAmountInForeignCurrency nullable: true
        itemInsuranceCurrencyExchangeRate nullable: true
        itemInsuranceCurrencyReferenceUnit nullable: true
        itemOtherCostsAmountInNationalCurrency nullable: true
        itemOtherCostsAmountInForeignCurrency nullable: true
        itemOtherCostsCurrencyExchangeRate nullable: true
        itemOtherCostsCurrencyReferenceUnit nullable: true
        itemDeductionsAmountInNationalCurrency nullable: true
        itemDeductionsAmountInForeignCurrency nullable: true
        itemDeductionsCurrencyExchangeRate nullable: true
        itemDeductionsCurrencyReferenceUnit nullable: true
        marketValueAmount nullable: true
        marketValueRate nullable: true
        marketValueBasisAmount nullable: true
        salePrice nullable: true
        freeOnBoardPrice nullable: true

    }

    static mapping = {
        version false
        table 'SAD_ITEM_VW'

        // Columns
        sad column: 'SAD_ID'
        rank column: 'KEY_ITM_NBR'
        id column: 'INSTANCE_ID'
//        nbrAskTaxFunc column: 'NBR_ASK_TAX_FUNC'
        packageNumber column: 'PCK_NBR', length: 10
        packageMark1 column: 'PCK_MRK1', length: 35
        packageMark2 column: 'PCK_MRK2', length: 35
        itemPackageTypeCode column: ' PCK_TYP_COD', length: 17
        itemPackageTypeName column: 'PCK_TYP_NAM', length: 35

        commodityCode column: 'TAR_HSC_NB1', length: 8

        commodityCodeNationalPrecision2 column: 'TAR_HSC_NB2', length: COM_CODE_NAT_PREC2_SIZE

        commodityCodeNationalPrecision3 column: 'TAR_HSC_NB3', length: 4
        commodityCodeNationalPrecision4 column: 'TAR_HSC_NB4', length: 4
        specificationCode column: 'TAR_HSC_NB5', length: 17
        //    specificationName column: 'TAR_HSC_NB5_NAM', length: 88

        tariffSpecificationCodeDate column: 'TAR_HSC_TSC_DAT'
        tariffSpecificationStatus column: 'TAR_HSC_TSC_STA', length: 1
        tariffPreferenceCode column: 'TAR_PRF', length: 8
        //   tariffPreferenceName column: 'TAR_PRF_NAM', length: 35

        extendedProcedureCode column: 'TAR_PRC_EXT', length: 4
        nationalProcedureCode column: 'TAR_PRC_NAT', length: 3

        price column: 'TAR_PRI'

        valuationMethodCode column: 'TAR_VMT', length: 1
        quota column: 'TAR_QUO', length: 5
        valuationDetails column: 'TAR_VDT', length: 75
        itemAttachedDocuments column: 'TAR_ATT', length: 55

        additionalInformationCode column: 'TAR_AIC', length: 3

        itemCountryOfOriginCode column: 'GDS_ORG_CTY', length: 2
        countryOfOriginRegionCode column: 'GDS_ORG_CRG', length: 4

        container1 column: 'GDS_CTN_CT1', length: 17
        container2 column: 'GDS_CTN_CT2', length: 17
        container3 column: 'GDS_CTN_CT3', length: 17
        container4 column: 'GDS_CTN_CT4', length: 17

        commodityDescription column: 'GDS_DSC', length: 88
        commercialDescription column: 'GDS_DS3', length: 88

        linkOfTransportDocument column: 'LNK_TPT', length: 85
        linkOfTransportDocumentSubLine column: 'LNK_TPT_SLN', length: 4
        previousDocumentReference column: 'LNK_PRV_DOC', length: 35
        additionalWarehouseCode column: 'LNK_PRV_WHS', length: 17
        additionalInformation column: 'TXT_FRE', length: 35
        processingPrograms column: 'TXT_RSV', length: 17
        //  processingProgramsProductCode column: 'PPP_COD', length: 17
        //   processingProgramsProductName column: 'PPP_NAM', length: 100

        licenseReferenceCode column: 'LIC_COD', length: 17
        deductedLicenseValueAmount column: 'LIC_AMT_VAL'
        deductedLicenseQuantity column: 'LIC_AMT_QTY'

        dutiesAndTaxesAmount column: 'TAX_AMT'
        guaranteedAmount column: 'TAX_GTY'
        modeOfPayment column: 'TAX_MOP', length: 1
        displayedAmount column: 'TAX_DTY'

        itemGrossMass column: 'VIT_WGT_GRS', length: 16
        netMass column: 'VIT_WGT_NET', length: 16
        /*   supplementaryAmount column: 'TAR_SUP_QTY', scale: 5
           supplementaryAmount1 column: 'TAR_SUP_QTY1', scale: 5
           supplementaryAmount2 column: 'TAR_SUP_QTY2', scale: 5
           supplementaryCode column: 'TAR_SUP_COD'
           supplementaryName column: 'TAR_SUP_NAM'
           warehouseUnitOfMeasurementCode column: 'WHS_UOM_COD'
           warehouseUnitOfMeasurementName column: 'WHS_UOM_NAM'
           warehouseUnitOfMeasurementQuantity column: 'WHS_UOM_QNT'*/
        addedCostsAmount column: 'VIT_CST', length: 16
        costInsuranceFreightAmount column: 'VIT_CIF', length: 16
        adjustmentRate column: 'VIT_ADJ', scale: 5
        alphaCoefficientOfApportionment column: 'VIT_ALP'
        statisticalValue column: 'VIT_STV', length: 16

        itemInvoiceAmountInNationalCurrency column: 'VIT_INV_AMT_NMU', length: 16
        itemInvoiceAmountInForeignCurrency column: 'VIT_INV_AMT_FCX', length: 16
        itemInvoiceCurrencyCode column: 'VIT_INV_CUR_COD', length: 3
        itemInvoiceCurrencyName column: 'VIT_INV_CUR_NAM', length: 35
        itemInvoiceCurrencyExchangeRate column: 'VIT_INV_CUR_RAT', scale: 5
        itemInvoiceCurrencyReferenceUnit column: 'VIT_INV_CUR_REF'

        itemExternalFreightAmountInNationalCurrency column: 'VIT_EFR_AMT_NMU', length: 16
        itemExternalFreightAmountInForeignCurrency column: 'VIT_EFR_AMT_FCX', length: 16
        itemExternalFreightCurrencyCode column: 'VIT_EFR_CUR_COD', length: 3
        itemExternalFreightCurrencyName column: 'VIT_EFR_CUR_NAM', length: 35
        itemExternalFreightCurrencyExchangeRate column: 'VIT_EFR_CUR_RAT', scale: 5
        itemExternalFreightCurrencyReferenceUnit column: 'VIT_EFR_CUR_REF'

        itemInternalFreightAmountInNationalCurrency column: 'VIT_IFR_AMT_NMU', length: 16
        itemInternalFreightAmountInForeignCurrency column: 'VIT_IFR_AMT_FCX', length: 16
        itemInternalFreightCurrencyCode column: 'VIT_IFR_CUR_COD', length: 3
        itemInternalFreightCurrencyName column: 'VIT_IFR_CUR_NAM', length: 35
        itemInternalFreightCurrencyExchangeRate column: 'VIT_IFR_CUR_RAT', scale: 5
        itemInternalFreightCurrencyReferenceUnit column: 'VIT_IFR_CUR_REF'

        itemInsuranceAmountInNationalCurrency column: 'VIT_INS_AMT_NMU', length: 16
        itemInsuranceAmountInForeignCurrency column: 'VIT_INS_AMT_FCX', length: 16
        itemInsuranceCurrencyCode column: 'VIT_INS_CUR_COD', length: 3
        itemInsuranceCurrencyName column: 'VIT_INS_CUR_NAM', length: 35
        itemInsuranceCurrencyExchangeRate column: 'VIT_INS_CUR_RAT', scale: 5
        itemInsuranceCurrencyReferenceUnit column: 'VIT_INS_CUR_REF'

        itemOtherCostsAmountInNationalCurrency column: 'VIT_OTC_AMT_NMU', length: 16
        itemOtherCostsAmountInForeignCurrency column: 'VIT_OTC_AMT_FCX', length: 16
        itemOtherCostsCurrencyCode column: 'VIT_OTC_CUR_COD', length: 3
        itemOtherCostsCurrencyName column: 'VIT_OTC_CUR_NAM', length: 35
        itemOtherCostsCurrencyExchangeRate column: 'VIT_OTC_CUR_RAT', scale: 5
        itemOtherCostsCurrencyReferenceUnit column: 'VIT_OTC_CUR_REF'

        itemDeductionsAmountInNationalCurrency column: 'VIT_DED_AMT_NMU', length: 16
        itemDeductionsAmountInForeignCurrency column: 'VIT_DED_AMT_FCX', length: 16
        itemDeductionsCurrencyCode column: 'VIT_DED_CUR_COD', length: 3
        itemDeductionsCurrencyName column: 'VIT_DED_CUR_NAM', length: 35
        itemDeductionsCurrencyExchangeRate column: 'VIT_DED_CUR_RAT', scale: 5
        itemDeductionsCurrencyReferenceUnit column: 'VIT_DED_CUR_REF'

        marketValueAmount column: 'VIT_MKT_AMT'
        marketValueRate column: 'VIT_MKT_RAT'
        marketValueCurrencyCode column: 'VIT_MKT_CUR', length: 3
        marketValueBasisDescription column: 'VIT_MKT_BSE_DSC', length: 35
        marketValueBasisAmount column: 'VIT_MKT_BSE_AMT'

        vinNumber column: 'BLK_VIN', length: 17
        salePrice column: 'BLK_SRP'
        freeOnBoardPrice column: 'BLK_FOB'
    }


    @Override
    boolean isFieldMandatory(String fieldName) {
        false
    }

    @Override
    boolean isFieldEditable(String fieldName) {
        false
    }

    def getSortedItemTaxes(){
            this.itemTaxes?.sort { i1, i2 -> comparator(i1, i2, ['rank'], DynamicFinder.ORDER_ASC) }
    }

    def comparator = { a1, a2, List sortFields, sortOrder ->
        def compareResult = 0
        for (def sortField : sortFields) {
            compareResult = a1."$sortField" <=> a2."$sortField"
            if (compareResult) {
                break
            }
        }
        if (sortOrder == DynamicFinder.ORDER_DESC) {
            compareResult = -compareResult
        }
        compareResult
    }

}
