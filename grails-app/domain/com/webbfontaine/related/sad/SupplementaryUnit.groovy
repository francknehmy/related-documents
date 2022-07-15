package com.webbfontaine.related.sad

class SupplementaryUnit implements Serializable{

    Integer rank
    BigDecimal supplementaryAmount // TAR_SUP_QTY
    String supplementaryCode // TAR_SUP_COD
    String supplementaryName // TAR_SUP_NAM

    static belongsTo = [item: Item]

    static mapping = {
        table name: 'SAD_SUPPLEMENTARY_UNIT_VW'
        version false
        id column: 'INSTANCE_ID'
        item column: 'ITEM_ID'
        supplementaryAmount column: 'TAR_SUP_QTY'
        supplementaryCode column: 'TAR_SUP_COD'
        supplementaryName column: 'TAR_SUP_NAM'
        rank column: 'KEY_SUP_RNK'
    }
}
