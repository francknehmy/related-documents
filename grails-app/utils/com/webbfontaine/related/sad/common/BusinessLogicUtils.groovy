package com.webbfontaine.related.sad.common

import org.joda.time.LocalDate
import java.text.SimpleDateFormat

class BusinessLogicUtils {

    static String buildSadReference(officeCode, declarationSerial, declarationNumber , declarationDate){
        officeCode + " " + declarationSerial + "" + declarationNumber + " " + new SimpleDateFormat("dd/MM/yyyy").format(new LocalDate(declarationDate).toDate())
    }

}
