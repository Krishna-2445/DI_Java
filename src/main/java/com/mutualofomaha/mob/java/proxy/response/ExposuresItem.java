package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class ExposuresItem{

	@JsonProperty("perils")
	private List<PerilsItem> perils;

	@JsonProperty("characteristics")
	private List<CharacteristicsItem> characteristics;

	@JsonProperty("productLocator")
	private String productLocator;

	@JsonProperty("policyholderLocator")
	private String policyholderLocator;

	@JsonProperty("createdTimestamp")
	private String createdTimestamp;

	@JsonProperty("name")
	private String name;

	@JsonProperty("policyLocator")
	private String policyLocator;

	@JsonProperty("displayId")
	private String displayId;

	@JsonProperty("locator")
	private String locator;

	@JsonProperty("updatedTimestamp")
	private String updatedTimestamp;

	public void setPerils(List<PerilsItem> perils){
		this.perils = perils;
	}

	public List<PerilsItem> getPerils(){
		return perils;
	}

	public void setCharacteristics(List<CharacteristicsItem> characteristics){
		this.characteristics = characteristics;
	}

	public List<CharacteristicsItem> getCharacteristics(){
		return characteristics;
	}

	public void setProductLocator(String productLocator){
		this.productLocator = productLocator;
	}

	public String getProductLocator(){
		return productLocator;
	}

	public void setPolicyholderLocator(String policyholderLocator){
		this.policyholderLocator = policyholderLocator;
	}

	public String getPolicyholderLocator(){
		return policyholderLocator;
	}

	public void setCreatedTimestamp(String createdTimestamp){
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedTimestamp(){
		return createdTimestamp;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPolicyLocator(String policyLocator){
		this.policyLocator = policyLocator;
	}

	public String getPolicyLocator(){
		return policyLocator;
	}

	public void setDisplayId(String displayId){
		this.displayId = displayId;
	}

	public String getDisplayId(){
		return displayId;
	}

	public void setLocator(String locator){
		this.locator = locator;
	}

	public String getLocator(){
		return locator;
	}

	public void setUpdatedTimestamp(String updatedTimestamp){
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUpdatedTimestamp(){
		return updatedTimestamp;
	}
}