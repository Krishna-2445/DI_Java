package com.mutualofomaha.mob.java.proxy;

import com.mutualofomaha.mob.java.client.SocotraClient;
import com.mutualofomaha.mob.java.config.SocotraProperties;
import com.mutualofomaha.mob.java.exception.SocotraServiceClientConnectionException;
import com.mutualofomaha.mob.java.exception.SocotraServiceException;
import com.mutualofomaha.mob.java.exception.SocotraServiceTimeoutException;
import com.mutualofomaha.mob.java.exception.SocotraServiceUnAuthorizedException;
import com.mutualofomaha.mob.java.proxy.request.CheckExistingPerilPremiumRequest;
import com.mutualofomaha.mob.java.proxy.response.CalculationResponse;
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
public class CheckExistingPerilPremiumProxy extends AbstractSocotraProxy {

    @Autowired
    AuthenticationProxy authenticationProxy;

    @Autowired
    private SocotraProperties socotraProperties;

    @Autowired
    CalculationResponse calculationResponse;

    public static final String CHECK_EXISTING_PERIL_PREMIUM_URI = "/calculation/checkExistingPerilPremium";

    private SocotraClient socotraClient = SocotraClient.getClient();

    public CalculationResponse checkExistingPerilPremium(final CheckExistingPerilPremiumRequest request) throws SocotraServiceException {
        log.info("CheckExistingPerilPremiumRequest processing started  for {}", request);

        Map<String, Object> data = new HashMap<>();
        data.put("calculation", request.getCalculation());
        data.put("perilDisplayId", request.getPerilDisplayId());

        final Object jsonObject = JsonHelper.toJSON(data);
        StopWatch watch = new StopWatch();
        watch.start();

        try {

            HttpHeaders requestHeaders = new HttpHeaders();

            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            this.addAndSignHeaders(requestHeaders, authenticationProxy.doAuthenticate());

            HttpEntity<?> entity = new HttpEntity<>(jsonObject.toString(), requestHeaders);

            ResponseEntity<CalculationResponse> responseEntity = socotraClient.getRestTemplate().exchange(getPolicyCreateUri(), HttpMethod.POST, entity, CalculationResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                calculationResponse = responseEntity.getBody();
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
        return calculationResponse;
    }

    public String getPolicyCreateUri() {
        return socotraProperties.getSocotraHostUri() + CHECK_EXISTING_PERIL_PREMIUM_URI;
    }

}
