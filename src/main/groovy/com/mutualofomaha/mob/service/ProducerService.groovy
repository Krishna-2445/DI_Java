package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.util.Constants
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
/**
 * Created by req87834 on 3/30/18.
 */
@Service
class ProducerService extends BaseService {

    def getProducerInformation(String producerNumber) {
        String path = "producer/licenseAppointment"
        def requestBody = [producerNumber: producerNumber,
                        company: "Mutual",
                        issueState: "NE",
                        appSignedDate: "2001-01-01",
                        effectiveDate: "2018-01-01"]

        HttpHeaders headers = new HttpHeaders()
        headers.add("BYPASS_SECURITY", "true")
        HttpEntity entity = new HttpEntity(requestBody, headers)
        try {
            def response = rest.exchange(Constants.producerServiceUrl + path, HttpMethod.POST, entity, String)
            return json.parseText(response.body)
        } catch(Exception e) {
            return []
        }
    }

    def getProducerInformationJson(String request) {
        def policy = json.parseText(request)

        //send policy to producerService
        def producerNumber = policy.policy.characteristics.fieldValues.producerNumber.flatten()
        def producer = getProducerInformation(producerNumber[0])
        def fieldValues = [
                appointmentStatus   : [""],
                licenseNumber       : [""],
                licenseEffectiveDate: [""],
                licenseState        : [""],
                company             : [""],
                producerIsCertified : [""]
        ]

        if (producer) {
            fieldValues = [
                    appointmentStatus   : [producer.producerAppointmentStatus == "0" ? "Appointed" : "Not appointed"],
                    licenseNumber       : [producer.licenseNumber],
                    licenseEffectiveDate: [producer.licenseEffectiveDate],
                    licenseState        : [producer.licenseStateCode],
                    company             : [producer.company],
                    producerIsCertified : [producer.amlCertificationUpToDate && producer.annualTrainingUptoDate]
            ]
        }

        return ["fieldValues": fieldValues]
    }
}