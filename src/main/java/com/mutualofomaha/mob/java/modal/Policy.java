package com.mutualofomaha.mob.java.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Component
public class Policy {

    @JsonProperty("policyStartTimestamp")
    private String policyStartTimestamp;

    @JsonProperty("exposure")
    @Autowired
    private Exposure exposure;

    @JsonProperty("peril")
    @Autowired
    private Peril peril;

    @JsonProperty("policyEndTimestamp")
    private String policyEndTimestamp;

    @JsonProperty("finalize")
    private Boolean finalize;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("policyHolder")
    private Map<String, List<Object>> policyHolder;

    @JsonProperty("fieldValues")
    private Map<String, List<String>> fieldValues;


}