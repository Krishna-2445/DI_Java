package com.mutualofomaha.mob.java.proxy.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Component
public class PolicyHolderDTO implements Serializable {

    private List<Object> first_name;
    private List<Object> last_name;
}
