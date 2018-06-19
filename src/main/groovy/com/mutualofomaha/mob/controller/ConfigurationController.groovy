package com.mutualofomaha.mob.controller

import com.mutualofomaha.mob.service.ConfigurationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/**
 * Created by req87834 on 4/11/18.
 */
@RestController
@RequestMapping(value = "/configuration")
class ConfigurationController {

    @Autowired
    ConfigurationService configurationService

    @GetMapping(value = "/")
    def getConfguration() {
        configurationService.getConfiguration()
    }
}
