package com.mutualofomaha.mob.java.proxy;

import com.mutualofomaha.mob.java.client.SocotraClient;
import com.mutualofomaha.mob.java.config.SocotraProperties;
import com.mutualofomaha.mob.java.exception.SocotraServiceClientConnectionException;
import com.mutualofomaha.mob.java.exception.SocotraServiceException;
import com.mutualofomaha.mob.java.exception.SocotraServiceTimeoutException;
import com.mutualofomaha.mob.java.exception.SocotraServiceUnAuthorizedException;
import com.mutualofomaha.mob.java.proxy.response.AuthenticationProxyResponse;
import com.mutualofomaha.mob.java.util.JsonHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.StopWatch;
import org.apache.http.conn.HttpHostConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class AuthenticationProxy {

    public static final String AUTHENTICATION_URI = "/account/authenticate";

    @Autowired
    private SocotraProperties socotraProperties;

    private SocotraClient socotraClient = SocotraClient.getClient();

    public AuthenticationProxyResponse doAuthenticate() throws SocotraServiceException {
        log.info("CreatePolicyRequest processing started ");

        AuthenticationProxyResponse response = null;

        Map<String, String> params = new HashMap<>();

        params.put("username", socotraProperties.getUsername());
        params.put("password", socotraProperties.getPassword());
        params.put("hostName", socotraProperties.getHostName());

        final Object jsonObject = JsonHelper.toJSON(params);
        StopWatch watch = new StopWatch();
        watch.start();

        try {

            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            HttpEntity<?> entity = new HttpEntity<>(jsonObject.toString(), requestHeaders);

            ResponseEntity<AuthenticationProxyResponse> responseEntity = socotraClient.getRestTemplate().exchange(getAuthenticationUri(), HttpMethod.POST, entity, AuthenticationProxyResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                response = responseEntity.getBody();
            }
        } catch (ResourceAccessException ex) {
            if (ex.contains(SocketTimeoutException.class)) {
                throw new SocotraServiceTimeoutException("Service timed out : Not received response from Gedi in request time");
            } else if (ex.contains(HttpHostConnectException.class)) {
                throw new SocotraServiceClientConnectionException("Unable to connect Gedi Service");
            }
        } catch (HttpClientErrorException ex) {
            throw new SocotraServiceUnAuthorizedException("UnAuthorized : Client Not able to Authorize");
        } catch (Exception ex) {
            throw new SocotraServiceException("Error Processing CreatePolicyRequest : " + ex.getLocalizedMessage());
        }
        return response;
    }

    public String getAuthenticationUri() {
        return socotraProperties.getSocotraHostUri() + AUTHENTICATION_URI;
    }

}
