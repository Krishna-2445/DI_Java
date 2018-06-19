package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class AuthenticationRequest {

    private String username;
    private String password;
    private String hostName;
    private String tenantName;

}
