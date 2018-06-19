package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class FieldGroupCreateRequest {

    private String fieldName;
    private Map<String, List<String>> fieldValues;

}
