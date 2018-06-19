package com.mutualofomaha.mob.entity

import javax.persistence.*
/**
 * Created by req87834 on 4/11/18.
 */
@Entity
@Table(name = "T_AUTH")
class Auth {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    Long id

    @Column(name = "USER_TXT")
    String user

    @Column(name = "TOKEN_TXT")
    String token

    @Column(name = "EXPIRES")
    Long expiresTimestamp
}
