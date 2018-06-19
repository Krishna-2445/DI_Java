package com.mutualofomaha.mob.util

import com.mutualofomaha.mob.service.EventListenerService
import com.mutualofomaha.mob.service.EventProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
/**
 * Created by req87834 on 3/30/18.
 */
@Component
class ScheduledTasks {

    @Autowired
    EventListenerService eventListenerService

    @Autowired
    EventProcessor eventProcessor

    @Scheduled(cron = "0 */1 * * * *")
    void writeEvents() {
        eventListenerService.getEvents()
    }

    @Scheduled(cron = "0 */2 * * * *")
    void processEvents() {
        eventProcessor.process()
    }
}
