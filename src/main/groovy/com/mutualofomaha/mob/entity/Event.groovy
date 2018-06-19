package com.mutualofomaha.mob.entity

import javax.persistence.*
/**
 * Created by req87834 on 4/11/18.
 */
@Entity
@Table(name = "T_EVENT")
class Event {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    Long id

    @Column(name = "TYPE_TXT")
    String eventType

    @Column(name = "LOCATOR_TXT")
    String locator

    @Column(name = "EVENT_TIMESTAMP")
    Long epochTime

    @Column(name = "PROCESSED_BOOL", columnDefinition = "boolean default false")\
    boolean processed

    @Column(name = "POLICY_JSON", columnDefinition = "text")
    String policyJson
}
