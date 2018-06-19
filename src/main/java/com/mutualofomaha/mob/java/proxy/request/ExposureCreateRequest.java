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
public class ExposureCreateRequest {

    private String exposureName;
    private List<FieldGroupCreateRequest> fieldGroups;
    private Map<String, List<String>> fieldValues;
    private List<PerilCreateRequest> perils;

}
