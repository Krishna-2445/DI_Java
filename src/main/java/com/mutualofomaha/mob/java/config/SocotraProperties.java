package com.mutualofomaha.mob.java.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "socotra")
public class SocotraProperties {

    private String username;
    private String password;
    private String hostName;
    private String socotraHostUri;

}
