package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.repos.AuthRepository
import com.mutualofomaha.mob.util.Constants
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
/**
 * Created by req87834 on 3/30/18.
 */
@Service
class AuthenticationService extends BaseService
{
    @Autowired
    AuthRepository authRepository

    String getAuthToken(String request, boolean isAdmin) {
        def slurpedRequest = json.parseText(request)

        if (hasValidToken(slurpedRequest.username)) {
            return "validToken"
        } else {
            requestNewToken(slurpedRequest.username, slurpedRequest.password, isAdmin)
        }
    }

    String getAuthToken(String request) {
        return getAuthToken(request, false)
    }

    boolean hasValidToken(String username) {
        return false
    }

    String requestNewToken(String username, String password, boolean isAdmin) {
        def requestBody

        if (isAdmin) {
            requestBody = [ username: username,
                            password: password]
        } else {
            requestBody = [ username: username,
                            password: password,
                            hostName: Constants.sandboxUrl]
        }

        def response = rest.postForEntity("/account/authenticate", requestBody, String)
        return json.parseText(response.body).authorizationToken
    }

    HttpEntity createEntity(String username, String password, boolean isAdmin, def entity) {
        HttpHeaders headers = new HttpHeaders()
        def request = new JsonBuilder([username: username, password: password, isAdmin: isAdmin]).toString()
        headers.set("Authorization", getAuthToken(request))
        if (entity) {
            return new HttpEntity(entity, headers)
        } else {
            return new HttpEntity(headers)
        }
    }

    HttpEntity createEntity(String username, String password, boolean isAdmin) {
        createEntity(username, password, isAdmin, null)
    }
}
