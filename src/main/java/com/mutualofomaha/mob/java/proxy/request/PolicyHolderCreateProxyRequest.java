package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
public class PolicyHolderCreateProxyRequest {

    private Map<String,List<Object>> policyHolder;

}
