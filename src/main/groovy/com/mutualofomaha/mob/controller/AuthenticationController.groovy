package com.mutualofomaha.mob.controller

import com.mutualofomaha.mob.service.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/**
 * Created by req87834 on 4/9/18.
 */
@RestController
@RequestMapping(value = "/authenticate", consumes = "application/json")
class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService

    @PostMapping(value = "/")
    String authenticate(@RequestBody String jsonRequest) {
        authenticationService.getAuthToken(jsonRequest)
    }

    @PostMapping(value = "/admin/")
    String authenticateAdmin(@RequestBody String jsonRequest) {
        authenticationService.getAuthToken(jsonRequest, true)
    }
}
