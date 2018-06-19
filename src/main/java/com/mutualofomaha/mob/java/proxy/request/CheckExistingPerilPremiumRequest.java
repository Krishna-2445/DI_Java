package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CheckExistingPerilPremiumRequest {

    private String calculation;
    private String perilDisplayId;

}
