package com.mutualofomaha.mob.controller

import com.mutualofomaha.mob.service.PolicyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by req87834 on 4/10/18.
 */
@RestController
@RequestMapping(value = "/policy")
class PolicyController {

    @Autowired
    PolicyService policyService

    @GetMapping(value = "/{policyLocator}/")
    def getPolicy(@PathVariable String policyLocator) {
        println("Getting policy: " + policyLocator)
        policyService.getPolicy(policyLocator)
    }

    @GetMapping(value = "/{policyLocator}/due/")
    def getAmountDue(@PathVariable String policyLocator) {
        policyService.getAmountDue(policyLocator)
    }

    @PostMapping(value = "/")
    def postPolicy(@RequestBody String jsonRequest) {
        policyService.postPolicy(jsonRequest)
    }

    @PostMapping(value = "/premium/")
    def getPremium(@RequestBody String jsonRequest) {
        policyService.getPremium(jsonRequest)
    }
}
