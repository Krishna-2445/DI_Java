package com.mutualofomaha.mob.java.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PolicyCharacteristics {

    @JsonProperty("policyStartTimestamp")
    private String policyStartTimestamp;

    @JsonProperty("fieldGroupsByLocator")
    private String fieldGroupsByLocator;

    @JsonProperty("policyEndTimestamp")
    private String policyEndTimestamp;

    @JsonProperty("fieldValues")
    private Map<String, List<String>> fieldValues;
}