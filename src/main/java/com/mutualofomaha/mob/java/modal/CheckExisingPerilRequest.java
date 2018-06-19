package com.mutualofomaha.mob.java.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckExisingPerilRequest {

    @JsonProperty("calculation")
    private String calculation;

    @JsonProperty("exposureName")
    private String exposureName;

    @JsonProperty("perilCharacteristics")
    private PerilCharacteristics perilCharacteristics;

    @JsonProperty("policyCharacteristics")
    private PolicyCharacteristics policyCharacteristics;

    @JsonProperty("perilName")
    private String perilName;

    @JsonProperty("exposureCharacteristics")
    private ExposureCharacteristics exposureCharacteristics;

    @JsonProperty("productName")
    private String productName;
}