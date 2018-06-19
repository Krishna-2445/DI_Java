package com.mutualofomaha.mob.java.proxy.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommissionResponse {

    private Integer amount;
    private String amountCurrency;
    private String recipient;
}
