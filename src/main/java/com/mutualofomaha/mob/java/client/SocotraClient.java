package com.mutualofomaha.mob.java.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class SocotraClient {

    private static SocotraClient client;
    private RestTemplate restTemplate;

    private SocotraClient() {
    }

    public static SocotraClient getClient() {
        if (client == null) {
            client = new SocotraClient();
            client.init();
        }
        return client;
    }

    private void init() {

        SimpleClientHttpRequestFactory clientFactory = new SimpleClientHttpRequestFactory();
        restTemplate = new RestTemplate(clientFactory);

    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
