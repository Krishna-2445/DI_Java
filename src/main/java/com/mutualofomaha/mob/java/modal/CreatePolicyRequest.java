package com.mutualofomaha.mob.java.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class CreatePolicyRequest {

	@JsonProperty("policy")
	@Autowired
	private Policy policy;

}