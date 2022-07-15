package com.webbfontaine.related.sad.command

import com.webbfontaine.grails.plugins.search.annotations.CriteriaField
import com.webbfontaine.grails.plugins.search.annotations.ResultField
import com.webbfontaine.grails.plugins.search.SearchResultOptions
import com.webbfontaine.grails.plugins.search.SearchUtils
import grails.validation.Validateable
import groovy.transform.ToString
import org.joda.time.LocalDate

import java.lang.reflect.Field

import static com.webbfontaine.related.sad.utils.TypeCastUtils.formatDate

/**
 * Copyrights 2002-2018 Webb Fontaine
 * Developer: Peter Arvin Bulong
 * Date: 2/14/2018
 * This software is the proprietary information of Webb Fontaine.
 * Its use is subject to License terms.
 */
@ToString
class SearchCommand implements Validateable, SearchResultOptions {
    static List<Field> resultFields
    static Map<String, ResultField> results

    static {
        results = SearchUtils.getResults(this)
        resultFields = SearchUtils.getResultFields(this)
    }

    SearchCommand() {
    }

    SearchCommand(Map map) {
        metaClass.setProperties(this, map.findAll { key, value -> this.hasProperty(key) })
    }

    @ResultField(width = 5, displayName = "related.status.label", pattern = "translatable")
    String status


    @CriteriaField(operator = "equals")
    @ResultField(width = 4, displayName = "related.declaration.office.label")
    String officeOfDispatchExportCode

    @CriteriaField(operator = "equals")
    @ResultField(width = 3, displayName = "related.declaration.serial.label")
    String customsRegistrationSerial

    @CriteriaField(operator = "equals")
    @ResultField(width = 5, displayName = "related.declaration.number.label")
    String customsRegistrationNumber

    @CriteriaField(operator = "equals")
    @ResultField(width = 7, displayName = "related.declaration.date.label", pattern = "date")
    LocalDate customsRegistrationDate

    @ResultField(width = 5, displayName = "related.declaration.consignee.label")
    String consigneeCode

    @ResultField(width = 5, displayName = "related.declaration.exporter.label")
    String exporterCode

    @ResultField(width = 6, displayName = "related.declaration.declarant.label")
    String declarantCode


    @Override
    Map getSearchParams(Object inputBean) {
        List fields = ['status', 'officeOfDispatchExportCode',
                       'declarantCode',
                       'customsRegistrationSerial', 'customsRegistrationNumber',  'exporterCode',
                       'consigneeCode']
        List dateFields = ['customsRegistrationDate']

        Map result = [:]
        fields.each {
            def value = inputBean."${it}"
            if (value) {
                result."${it}" = value
            }
        }
        dateFields.each {
            def value = formatDate(inputBean."${it}")
            if (value) {
                result."${it}" = value
            }
        }

        result
    }

    @Override
    List<Field> getResultFields() {
        if (!resultFields) {
            resultFields = SearchUtils.getResultFields(this)
        }
        return resultFields
    }

    @Override
    Map<String, ResultField> getResults() {
        if (!results) {
            results = SearchUtils.getResults(this)
        }
        return results
    }
}
