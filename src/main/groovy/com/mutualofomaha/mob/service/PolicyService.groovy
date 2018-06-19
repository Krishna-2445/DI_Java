package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
/**
 * Created by req87834 on 4/9/18.
 */
@Service
class PolicyService extends BaseService {

    @Autowired
    AuthenticationService auth

    def getPolicy(String locator) {
        def response = rest.exchange("/policy/$locator",
                HttpMethod.GET,
                auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false),
                String)
        return response.body
    }

    /**
     Json request should look like the following:
     {
         // Required
         "policyholderLocator" : string,

         "productName" : string

         // Optional
         "exposures" : [ExposureCreateRequest],

         "fieldGroups" : [FieldGroupCreateRequest],

         "fieldValues" : map<string, [string]>,

         "finalize" : boolean,

         "paymentScheduleName" : string,

         "policyEndTimestamp" : integer,

         "policyStartTimestamp" : integer
     }
     */

    def postPolicy(def jsonRequest) {
        def response = rest.exchange("/policy",
                HttpMethod.POST,
                auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false, jsonRequest),
                String)

        return response.body
    }

    /**
     Json request should look like the following:
     {
         "calculation" : string,

         "exposureCharacteristics" : ExposureCharacteristicsPriceRequest,

         "exposureName" : string,

         "perilCharacteristics" : PerilCharacteristicsPriceRequest,

         "perilName" : string,

         "policyCharacteristics" : PolicyCharacteristicsPriceRequest,

         "productName" : string
     }
     */

    def getPremium(def jsonRequest) {
        def response = rest.exchange("/calculation/checkPerilPremium",
            HttpMethod.POST,
            auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false, jsonRequest),
            String)

        return response.body
    }

    def getAmountDue(String policyLocator) {
        def policy = json.parseText(getPolicy(policyLocator))
        float total = 0
        policy.invoices?.each { invoice ->
            if (invoice.settlementStatus != "settled"){
                total += Float.valueOf(invoice.totalDue)
            }
        }
        return total
    }

    def renewPolicy(String policyJson) {
        def policy = json.parseText(policyJson)

        def renewalEndTimestamp = Long.valueOf(policy.effectiveContractEndTimestamp) + (3600000L * 24L * 30L)

        def jsonRequest = [renewalEndTimestamp: renewalEndTimestamp ]

        def response = rest.exchange("/policy/${policy.locator}/issueRenewal",
        HttpMethod.POST,
        auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false, jsonRequest),
        String)

        return response.body
    }
}
