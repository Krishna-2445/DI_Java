package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Component
public class PolicyCreateRequest {

    private String policyholderLocator;
    private String productName;
    private List<ExposureCreateRequest> exposures;
    private List<FieldGroupCreateRequest> fieldGroups;
    private Map<String, List<String>> fieldValues;
    private Boolean finalize;
    private String paymentScheduleName;
    private long policyEndTimestamp;
    private long policyStartTimestamp;

}
