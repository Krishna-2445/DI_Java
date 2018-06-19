package com.mutualofomaha.mob.java.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutualofomaha.mob.java.exception.SocotraServiceException;
import com.mutualofomaha.mob.java.modal.CreatePolicyRequest;
import com.mutualofomaha.mob.java.proxy.response.CalculationResponse;
import com.mutualofomaha.mob.java.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/premium")
public class PremiumController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    PolicyService policyService;

    @PostMapping(value = "/getPremium", produces = "application/json")
    public CalculationResponse getPremium(@RequestBody String jsonRequest) throws IOException, ParseException, SocotraServiceException {

        CreatePolicyRequest perilRequest = objectMapper.readValue(jsonRequest, CreatePolicyRequest.class);
        return policyService.checkExistingPerilPremium(perilRequest);

    }

}
