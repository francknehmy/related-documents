package com.webbfontaine.related.sad

import com.webbfontaine.grails.plugins.taglibs.ConfigurableFields

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormValidateable
import org.joda.time.LocalDate

@GrailsCompileStatic
class AttachedDocument implements Serializable, ConfigurableFields, GormValidateable {

    Integer rank
    String attachedDocCode                  // docCode
    String attachedDocName                  // docType
    String attachedDocReference             // docRef
    LocalDate date
    String rule
    Long sadId
    Integer itemNumber

  //  AttachedFile attachedFile
  //  String extensionDoc

    Integer getItemRank() {
        this.item?.rank
    }


    // Associations
    static belongsTo = [item: Item]

    static constraints = {
       // attachedFile nullable: true
        rank nullable: true
      //  item nullable: false
        attachedDocCode nullable: false
        attachedDocReference nullable: false
       // attachmentExternalId nullable: true
     //   media nullable: true
        rule nullable: true
        attachedDocName nullable: true
        date nullable: true
     //   extensionDoc nullable: true
    }

    static mapping = {
        version false
        table 'SAD_ATTACHED_DOCUMENTS_VW'
        id composite: ['sadId', 'itemNumber', 'rank']
        sadId column: 'INSTANCE_ID'
        itemNumber column: 'KEY_ITM_NBR'
        item column: 'ITEM_ID'
        attachedDocCode column: 'COD', length: 4
        attachedDocName column: 'NAM', length: 70
        attachedDocReference column: 'REF', length: 35
       // attachmentExternalId
       // column: 'EID', length: 36
        rank column: 'KEY_RNK'
        date column: 'DAT'
        rule column: 'RUL', length: 1
       // attachedFile column: 'ATT_FIL', cascade: 'all-delete-orphan'
       // extensionDoc column: 'EXT_DOC'
    }


  /*  @GrailsCompileStatic(TypeCheckingMode.SKIP)
    AttachedFile retrieveAttachedFile(boolean loadIfNotLoaded = true) {
        AttachedFile result = null
        if (!isUpdated && attachedFileId && loadIfNotLoaded) {
            result = AttachedFile.findById(attachedFileId)
        } else {
            result = attachedFile
        }
        return result
    }
*/


    @Override
    boolean isFieldMandatory(String fieldName) {
       false
    }

    @Override
    boolean isFieldEditable(String fieldName) {
       false
    }

}
