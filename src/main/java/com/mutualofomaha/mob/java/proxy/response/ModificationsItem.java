package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class ModificationsItem{

	@JsonProperty("effectiveTimestamp")
	private String effectiveTimestamp;

	@JsonProperty("fieldGroupsByLocator")
	private FieldGroupsByLocator fieldGroupsByLocator;

	@JsonProperty("newPolicyCharacteristicsLocator")
	private String newPolicyCharacteristicsLocator;

	@JsonProperty("mediaByLocator")
	private MediaByLocator mediaByLocator;

	@JsonProperty("exposureModifications")
	private List<ExposureModificationsItem> exposureModifications;

	@JsonProperty("createdTimestamp")
	private String createdTimestamp;

	@JsonProperty("fieldValues")
	private FieldValues fieldValues;

	@JsonProperty("newPolicyCharacteristicsLocators")
	private List<String> newPolicyCharacteristicsLocators;

	@JsonProperty("updatedTimestamp")
	private String updatedTimestamp;

	@JsonProperty("number")
	private String number;

	@JsonProperty("productLocator")
	private String productLocator;

	@JsonProperty("policyholderLocator")
	private String policyholderLocator;

	@JsonProperty("name")
	private String name;

	@JsonProperty("policyLocator")
	private String policyLocator;

	@JsonProperty("premiumChangeCurrency")
	private String premiumChangeCurrency;

	@JsonProperty("displayId")
	private String displayId;

	@JsonProperty("locator")
	private String locator;

	public void setEffectiveTimestamp(String effectiveTimestamp){
		this.effectiveTimestamp = effectiveTimestamp;
	}

	public String getEffectiveTimestamp(){
		return effectiveTimestamp;
	}

	public void setFieldGroupsByLocator(FieldGroupsByLocator fieldGroupsByLocator){
		this.fieldGroupsByLocator = fieldGroupsByLocator;
	}

	public FieldGroupsByLocator getFieldGroupsByLocator(){
		return fieldGroupsByLocator;
	}

	public void setNewPolicyCharacteristicsLocator(String newPolicyCharacteristicsLocator){
		this.newPolicyCharacteristicsLocator = newPolicyCharacteristicsLocator;
	}

	public String getNewPolicyCharacteristicsLocator(){
		return newPolicyCharacteristicsLocator;
	}

	public void setMediaByLocator(MediaByLocator mediaByLocator){
		this.mediaByLocator = mediaByLocator;
	}

	public MediaByLocator getMediaByLocator(){
		return mediaByLocator;
	}

	public void setExposureModifications(List<ExposureModificationsItem> exposureModifications){
		this.exposureModifications = exposureModifications;
	}

	public List<ExposureModificationsItem> getExposureModifications(){
		return exposureModifications;
	}

	public void setCreatedTimestamp(String createdTimestamp){
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedTimestamp(){
		return createdTimestamp;
	}

	public void setFieldValues(FieldValues fieldValues){
		this.fieldValues = fieldValues;
	}

	public FieldValues getFieldValues(){
		return fieldValues;
	}

	public void setNewPolicyCharacteristicsLocators(List<String> newPolicyCharacteristicsLocators){
		this.newPolicyCharacteristicsLocators = newPolicyCharacteristicsLocators;
	}

	public List<String> getNewPolicyCharacteristicsLocators(){
		return newPolicyCharacteristicsLocators;
	}

	public void setUpdatedTimestamp(String updatedTimestamp){
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUpdatedTimestamp(){
		return updatedTimestamp;
	}

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
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

	public void setPremiumChangeCurrency(String premiumChangeCurrency){
		this.premiumChangeCurrency = premiumChangeCurrency;
	}

	public String getPremiumChangeCurrency(){
		return premiumChangeCurrency;
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
}