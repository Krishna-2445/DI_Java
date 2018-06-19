package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.entity.Event
import com.mutualofomaha.mob.repos.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
/**
 * Created by req87834 on 4/11/18.
 */
@Service
class EventProcessor {

    @Autowired
    EventRepository eventRepository

    @Autowired
    PolicyService policyService

    int process() {
        List<Event> events = eventRepository.findByProcessedFalse()

        events.each { event ->
            if (event.eventType == "payment.pay") {
                policyService.renewPolicy(event.policyJson)
            }

            event.processed = true
            eventRepository.save(event)
        }
        return events.size()
    }
}
