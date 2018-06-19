package com.mutualofomaha.mob.controller

import com.mutualofomaha.mob.service.PolicyHolderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/**
 * Created by req87834 on 4/21/18.
 */
@RestController
@RequestMapping(value = "/policyholder")
class PolicyHolderController {

    @Autowired
    PolicyHolderService policyHolderService

    @PostMapping(value = "/create/")
    def createPolicyHolder(String jsonRequest) {
//        policyHolderService.
    }
}
