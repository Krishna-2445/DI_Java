package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@Component
public class AuthenticationProxyRequest {

    private String username;
    private String password;
    private String hostName;
    private String tenantName;

    private Map<String, Object> parameterMap = new HashMap<>();
}
