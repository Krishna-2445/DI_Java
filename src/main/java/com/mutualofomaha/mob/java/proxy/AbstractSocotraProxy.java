package com.mutualofomaha.mob.java.proxy;

import com.mutualofomaha.mob.java.proxy.response.AuthenticationProxyResponse;
import org.springframework.http.HttpHeaders;

public abstract class AbstractSocotraProxy {

    private static final String AUTHORIZATION = "Authorization";


    public void addAndSignHeaders(final HttpHeaders message, final AuthenticationProxyResponse response) {

        message.set(AUTHORIZATION, response.getAuthorizationToken());

    }

}
