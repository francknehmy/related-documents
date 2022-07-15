package com.webbfontaine.related.sad.utils

import grails.util.Holders
import org.joda.time.LocalDate
import org.joda.time.ReadablePartial
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

/**
 * Copyrights 2002-2018 Webb Fontaine
 * Developer: Peter Arvin Bulong
 * Date: 2/14/2018
 * This software is the proprietary information of Webb Fontaine.
 * Its use is subject to License terms.
 */
class TypeCastUtils {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern(datePattern())
    private static volatile DateTimeFormatter DEFAULT_FORMATTER


    static String datePattern() {
        Holders.config.jodatime.format.org.joda.time.LocalDate
    }

    static String formatDate(ReadablePartial date) {
        return date ? getDefaultFormatter().print(date) : ''
    }


    private static def getDefaultFormatter() {
        if (!DEFAULT_FORMATTER) {
            DEFAULT_FORMATTER = DateTimeFormat.forPattern(datePattern())
        }

        return DEFAULT_FORMATTER
    }

}
