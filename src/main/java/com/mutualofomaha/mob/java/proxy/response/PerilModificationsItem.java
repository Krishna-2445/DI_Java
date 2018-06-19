package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PerilModificationsItem{

	@JsonProperty("newPerilCharacteristicsLocator")
	private String newPerilCharacteristicsLocator;

	@JsonProperty("exposureModificationLocator")
	private String exposureModificationLocator;

	@JsonProperty("productLocator")
	private String productLocator;

	@JsonProperty("policyholderLocator")
	private String policyholderLocator;

	@JsonProperty("policyLocator")
	private String policyLocator;

	@JsonProperty("perilLocator")
	private String perilLocator;

	@JsonProperty("premiumChangeCurrency")
	private String premiumChangeCurrency;

	@JsonProperty("locator")
	private String locator;

	public void setNewPerilCharacteristicsLocator(String newPerilCharacteristicsLocator){
		this.newPerilCharacteristicsLocator = newPerilCharacteristicsLocator;
	}

	public String getNewPerilCharacteristicsLocator(){
		return newPerilCharacteristicsLocator;
	}

	public void setExposureModificationLocator(String exposureModificationLocator){
		this.exposureModificationLocator = exposureModificationLocator;
	}

	public String getExposureModificationLocator(){
		return exposureModificationLocator;
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

	public void setPolicyLocator(String policyLocator){
		this.policyLocator = policyLocator;
	}

	public String getPolicyLocator(){
		return policyLocator;
	}

	public void setPerilLocator(String perilLocator){
		this.perilLocator = perilLocator;
	}

	public String getPerilLocator(){
		return perilLocator;
	}

	public void setPremiumChangeCurrency(String premiumChangeCurrency){
		this.premiumChangeCurrency = premiumChangeCurrency;
	}

	public String getPremiumChangeCurrency(){
		return premiumChangeCurrency;
	}

	public void setLocator(String locator){
		this.locator = locator;
	}

	public String getLocator(){
		return locator;
	}
}