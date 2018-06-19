package com.mutualofomaha.mob.java.proxy;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutualofomaha.mob.java.client.SocotraClient;
import com.mutualofomaha.mob.java.config.SocotraProperties;
import com.mutualofomaha.mob.java.exception.SocotraServiceClientConnectionException;
import com.mutualofomaha.mob.java.exception.SocotraServiceException;
import com.mutualofomaha.mob.java.exception.SocotraServiceTimeoutException;
import com.mutualofomaha.mob.java.exception.SocotraServiceUnAuthorizedException;
import com.mutualofomaha.mob.java.proxy.request.PolicyCreateProxyRequest;
import com.mutualofomaha.mob.java.proxy.response.CreatePolicyResponse;
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
import java.util.Map;

@Component
@Slf4j
public class CreatePolicyProxy extends AbstractSocotraProxy {

    @Autowired
    AuthenticationProxy authenticationProxy;

    @Autowired
    private SocotraProperties socotraProperties;

    @Autowired
    CreatePolicyResponse response;

    public static final String CREATE_POLICY_URI = "/policy";

    private SocotraClient socotraClient = SocotraClient.getClient();

    public CreatePolicyResponse createPolicy(final PolicyCreateProxyRequest request) throws SocotraServiceException {
        log.info("CreatePolicyRequest processing started  for {}", request);

        final ObjectMapper objMapper = new ObjectMapper();
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Map<String, Object> data = objMapper.convertValue(request.getRequest(), Map.class);

        final Object jsonObject = JsonHelper.toJSON(data);
        StopWatch watch = new StopWatch();
        watch.start();

        try {

            HttpHeaders requestHeaders = new HttpHeaders();

            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            this.addAndSignHeaders(requestHeaders, authenticationProxy.doAuthenticate());

            HttpEntity<?> entity = new HttpEntity<>(jsonObject.toString(), requestHeaders);

            ResponseEntity<CreatePolicyResponse> responseEntity = socotraClient.getRestTemplate().exchange(getPolicyCreateUri(), HttpMethod.POST, entity, CreatePolicyResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                response = responseEntity.getBody();
                log.info("Policy Created Successfully and locator value is: {}", response.getLocator());
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

    public String getPolicyCreateUri() {
        return socotraProperties.getSocotraHostUri() + CREATE_POLICY_URI;
    }

}
