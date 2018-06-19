package com.mutualofomaha.mob.java.proxy.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Component
public class AuthenticationResponse implements Serializable {

    private String authorizationToken;
    private Integer expiresTimestamp;

}
