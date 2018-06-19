package com.mutualofomaha.mob.java.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PerilCharacteristics{

    @JsonProperty("fieldGroupsByLocator")
    private String fieldGroupsByLocator;

    @JsonProperty("fieldValues")
    private Map<String, List<String>> fieldValues;

}