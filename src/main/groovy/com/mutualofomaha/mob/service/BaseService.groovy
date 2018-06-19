package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.util.Constants
import groovy.json.JsonSlurper
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriTemplateHandler
/**
 * Created by req87834 on 4/9/18.
 */
class BaseService {
    JsonSlurper json
    RestTemplate rest

    BaseService() {
        json = new JsonSlurper()
        rest = new RestTemplate() //getRequestFactory())

        DefaultUriTemplateHandler defaultUriTemplateHandler = new DefaultUriTemplateHandler()
        defaultUriTemplateHandler.baseUrl = Constants.baseUrl
        rest.setUriTemplateHandler(defaultUriTemplateHandler)
    }
}
