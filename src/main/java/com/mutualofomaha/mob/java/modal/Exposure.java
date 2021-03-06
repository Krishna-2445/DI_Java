package com.mutualofomaha.mob.java.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Exposure {

    @JsonProperty("exposureName")
    private String exposureName;

    @JsonProperty("fieldValues")
    private Map<String, List<String>> fieldValues;


}