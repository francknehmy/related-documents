# **Guce docViewer SQL Scripts**


### SWDOCCI-142 View Multiple Previous Declaration
**Create OR Replace View Table for additional Column for Previous Declaration**

    --------------------------------------------------

    CREATE OR REPLACE VIEW SAD_INT_VW AS select
    CONCAT(INSTANCEID,KEY_INT_NBR) as INSTANCE_ID,
    si.INSTANCEID as SAD_ID,
    si.KEY_INT_NBR,
    si.IDE_REG_DAT AS DEC_REF_YER,
    si.IDE_CUO_COD,
    si.IDE_REG_SER,
    si.IDE_REG_NBR,
    si.TAR_HSC_ART,
    si.TAR_HSC_NB1,
    si.TAR_HSC_NB2,
    si.GDS_ORG_CTY,
    si.VAL_PRC AS VAL_CUR,
    si.PCK_NBR,
    si.PCP_NBR,
    si.SUP_QTY,
    si.SPP_QTY,
    si.PCK_NBR AS WRT_PCK_NBR,
    si.VIT_WGT_NET AS WRT_WGT_NET,
    si.SUP_QTY AS WRT_SUP_QTY,
    ai.IDE_REG_DAT,
    ai.WHS_COD,
    ai.WHS_TIM AS EXP_DAT,
    ait.PCK_NBRI,
    ait.TAR_PRC_EXT,
    ait.VIT_WGT_NETI,
    ait.VIT_WGT_NET,
    ast.tar_sup_qty,
    ast.tar_sup_qtyi
    from qasydammod.sad_int si,
    qasydammod.asyint_tab ai,
    qasydammod.asyint_itm_tab ait,
    qasydammod.asyint_sup_tab ast
    where
    si.IDE_REG_NBR = ai.ide_reg_nbr and
    si.IDE_REG_SER = ai.IDE_REG_SER and 
    si.IDE_REG_DAT = ai.DEC_REF_YER and
    si.IDE_CUO_COD = ai.IDE_CUO_COD and
    ai.instance_id = ait.instance_id and
    si.KEY_INT_NBR = ait.KEY_ITM_NBR and
    ai.instance_id = ast.instance_id
    /
    --------------------------------------------------
    
### SWDOCCI-165 Improved show operation performance. Modified queries on SAD_ATTACHED_DOCUMENTS_VW and SAD_TAX_VW to use indexes of Base table

    --------------------------------------------------
    CREATE OR REPLACE FORCE VIEW "SYDAMVIEWS"."SAD_TAX_VW" ("INSTANCE_ID", "ITEM_ID", "KEY_ITM_NBR", "KEY_TAX_RNK", "TAX_LIN_COD", "TAX_LIN_BSE", "TAX_LIN_RAT", "TAX_LIN_AMT", "TAX_LIN_MOP", "TAX_LIN_TYP") AS 
    SELECT 
        INSTANCEID,
        INSTANCEID as ITEM_ID,
        KEY_ITM_NBR as KEY_ITM_NBR,
        KEY_TAX_RNK,
        TAX_LIN_COD,
        TAX_LIN_BSE,
        TAX_LIN_RAT,
        TAX_LIN_AMT,
        TAX_LIN_MOP,
        TAX_LIN_TYP
    FROM 
    awunadm.SAD_TAX
    order by INSTANCEID, KEY_ITM_NBR;
 
    CREATE OR REPLACE FORCE VIEW "SYDAMVIEWS"."SAD_ATTACHED_DOCUMENTS_VW" ("INSTANCE_ID", "ITEM_ID", "KEY_ITM_NBR", "KEY_RNK", "COD", "NAM", "REF", "DAT", "RUL", "IMG") AS 
    select
        INSTANCEID as INSTANCE_ID,
        INSTANCEID as ITEM_ID,
        KEY_ITM_NBR as KEY_ITM_NBR,
        KEY_RNK,
        COD,
        NAM,
        REF,
        DAT,
        RUL,
        IMG
    from 
    awunadm.SAD_ATTACHED_DOCUMENTS
    order by INSTANCEID, KEY_ITM_NBR, COD;
    
    --------------------------------------------------

   