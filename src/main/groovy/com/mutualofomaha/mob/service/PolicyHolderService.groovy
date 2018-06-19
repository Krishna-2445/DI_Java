package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

/**
 * Created by req87834 on 4/21/18.
 */
@Service
class PolicyHolderService extends BaseService {

    @Autowired
    AuthenticationService auth

    def createPolicyHolder(String jsonRequest) {
        def policyholder = json.parseText(jsonRequest)

        def request = [values: policyholder]

        println("Request: " + request)

        def response = rest.exchange("/policyholder/create",
                HttpMethod.POST,
                auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false, request),
                String)

        println("Response: " + response)

        return response.body
    }
}
