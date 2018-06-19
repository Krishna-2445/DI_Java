package com.mutualofomaha.mob.controller

import com.mutualofomaha.mob.service.ProducerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * Created by req87834 on 3/30/18.
 */

@RestController
@RequestMapping(value = "/producer")
class ProducerController {

    @Autowired
    ProducerService producerService

    @GetMapping(value = "/{producerNumber}/")
    def getProducerInformation(@PathVariable String producerNumber) {
        producerService.getProducerInformation(producerNumber)
    }

    @PostMapping(value = "/")
    def getProducerInformationFromJson(@RequestBody String policy) {
        producerService.getProducerInformationJson(policy)
    }
}
