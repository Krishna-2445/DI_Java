package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

/**
 * Created by req87834 on 4/4/18.
 */
@Service
class ConfigurationService extends BaseService{

    @Autowired
    AuthenticationService auth

    def getConfiguration() {
        def response = rest.exchange( "/products",
                HttpMethod.GET,
                auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false),
                String)
        return response.body
    }
}
