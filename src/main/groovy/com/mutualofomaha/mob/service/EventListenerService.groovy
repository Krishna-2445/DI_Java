package com.mutualofomaha.mob.service

import com.mutualofomaha.mob.entity.Event
import com.mutualofomaha.mob.repos.EventRepository
import com.mutualofomaha.mob.util.Constants
import groovy.time.TimeCategory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder
/**
 * Created by req87834 on 3/30/18.
 * This service only listens to the event listener and writes the data out to a file/DB/kafka
 *
 * The Event processor service reads the newly added data, and processes it
 */
@Service
class EventListenerService extends BaseService {

    @Autowired
    AuthenticationService auth

    @Autowired
    EventRepository eventRepository

    @Autowired
    PolicyService policyService

    def getEvents() {
        String path = "/eventstream/events"

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.baseUrl + path)
            .queryParam("endTimestamp", new Date().getTime())
            .queryParam("startTimestamp", getStartTimestamp())

        def response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                auth.createEntity(Constants.tenantUsername, Constants.tenantPassword, false),
                String)

        List<Map> events = json.parseText(response.body).events

        saveEvents(events)
        return events
    }

    def getStartTimestamp() {
        use(TimeCategory) {
            def date = new Date()
            return (date-Constants.eventListenerInterval.minutes).getTime()
        }
    }

    def saveEvents(def events) {
        events.each { event ->
            Event eventObj = new Event()
            eventObj.with {
                eventType = event.type
                locator = event.data.policyLocator
                epochTime = Long.valueOf(event.timestamp)
                policyJson = policyService.getPolicy(event.data.policyLocator)
            }
            eventRepository.save(eventObj)
        }
    }
}
