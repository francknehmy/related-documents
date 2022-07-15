package com.webbfontaine.related.sad.rest

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.util.EntityUtils

import javax.servlet.http.HttpServletResponse

@Slf4j("LOGGER")
class HttpClientUtil {
    static <T extends HttpUriRequest> Map getData(HttpResponse response, String dataType) {
        try {
            int statusCode = response.getStatusLine().statusCode;
            def data = null
            if (response) {
                if (dataType == "json") {
                    data = jsonFromHttpResponse(response)
                }
            }
            LOGGER.debug("statusCode = {}.", statusCode)
            return ["statusCode": statusCode, data: data]
        } catch (IllegalArgumentException e) {
            LOGGER.error("", e)
            return ["statusCode": HttpServletResponse.SC_UNAUTHORIZED]
        }
        finally {
            response?.close()
        }
    }

    static def jsonFromHttpResponse(HttpResponse response) {
        def jsonSlurper = new JsonSlurper()
        return jsonSlurper.parseText(EntityUtils.toString(response.getEntity()))
    }
}
