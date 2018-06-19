package com.mutualofomaha.mob.java.service;


import com.mutualofomaha.mob.java.exception.SocotraServiceException;
import com.mutualofomaha.mob.java.modal.CreatePolicyRequest;
import com.mutualofomaha.mob.java.proxy.response.CalculationResponse;

import java.text.ParseException;

public interface PolicyService {

    public CalculationResponse checkExistingPerilPremium(CreatePolicyRequest perilRequest) throws SocotraServiceException, ParseException;

}
