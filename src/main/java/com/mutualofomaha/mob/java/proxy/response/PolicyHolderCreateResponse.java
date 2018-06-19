package com.mutualofomaha.mob.java.proxy.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ToString
public class PolicyHolderCreateResponse {

    private String createdTimestamp;
    private String locator;
}
