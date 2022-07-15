package com.webbfontaine.related.sad

import com.webbfontaine.related.sad.constants.RelatedConstants
import com.webbfontaine.related.sad.rest.Command
import com.webbfontaine.related.sad.rest.HttpClientUtil
import com.webbfontaine.related.sad.utils.AppConfig
import grails.gorm.transactions.Transactional
import groovy.json.JsonBuilder
import groovy.util.logging.Slf4j
import org.apache.http.HttpStatus
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.CredentialsProvider
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.conn.HttpHostConnectException
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

@Transactional
@Slf4j("LOGGER")
class RelatedDocumentService {

    def processRelatedDocument(String document, command) {
        List resultList = []
            if (document.equals(RelatedConstants.TIMBER)) {
                resultList = AppConfig.isRelatedDocumentEnabledFor(document) ? manageResponse(document, command)  : new ArrayList<>()
            }
        resultList
    }

    def manageResponse(document, command){
        Map result = retrieveRelatedDocument(document, command)
        List data = new ArrayList()
        if(result?.data?.code == "00"){
            data = result?.data?.payload?."${document}"
        }
        data
    }

    def retrieveRelatedDocument(document, command) {
        String url = AppConfig.resolveRetrieveRelatedDocumentURL(document)
        HttpPost request
        Map result = null
        CloseableHttpClient client
        CloseableHttpResponse response
        try {
            request = new HttpPost("${url}")
            client = HttpClients.custom()
                    .setDefaultCredentialsProvider(setBasicAuthentification())
                    .build()
            request.setEntity(prepareParameter(request, command))
            response = client.execute(request)
            int statusCode = response.getStatusLine().getStatusCode()
            LOGGER.info("Receive Response statusCode : {}", statusCode)
            if (statusCode != HttpStatus.SC_OK) {
                LOGGER.info("got an exception : {}", statusCode)
            }
            LOGGER.info("Receive Response  : {}", response)
            result = HttpClientUtil.getData(response, "json")
            LOGGER.info("Processing conversion Response to json   : {}", result)
            LOGGER.info("data from response json : {}", result.data)
            return result
        } catch (ConnectException| HttpHostConnectException|IllegalArgumentException e) {
            LOGGER.error("Error Encountered ", e)
            result = [error : true]
            return result
        }
    }

    CredentialsProvider setBasicAuthentification() {
        CredentialsProvider provider = new BasicCredentialsProvider()
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(AppConfig.basicUser, AppConfig.basicPassword)
        provider.setCredentials(AuthScope.ANY, credentials)
        provider
    }

    StringEntity prepareParameter(HttpPost request, Command params) {
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json")
        String inputJson = new JsonBuilder(params).toPrettyString()
        return new StringEntity(inputJson)
    }
}
