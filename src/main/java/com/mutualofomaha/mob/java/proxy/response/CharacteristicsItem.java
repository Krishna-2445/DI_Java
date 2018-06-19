package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CharacteristicsItem{

	@JsonProperty("indemnityInAggregateCurrency")
	private String indemnityInAggregateCurrency;

	@JsonProperty("fieldGroupsByLocator")
	private FieldGroupsByLocator fieldGroupsByLocator;

	@JsonProperty("indemnityPerItemCurrency")
	private String indemnityPerItemCurrency;

	@JsonProperty("mediaByLocator")
	private MediaByLocator mediaByLocator;

	@JsonProperty("createdTimestamp")
	private String createdTimestamp;

	@JsonProperty("indemnityPerEventCurrency")
	private String indemnityPerEventCurrency;

	@JsonProperty("perilLocator")
	private String perilLocator;

	@JsonProperty("fieldValues")
	private FieldValues fieldValues;

	@JsonProperty("updatedTimestamp")
	private String updatedTimestamp;

	@JsonProperty("exposureCharacteristicsLocator")
	private String exposureCharacteristicsLocator;

	@JsonProperty("policyModificationLocator")
	private String policyModificationLocator;

	@JsonProperty("coverageEndTimestamp")
	private String coverageEndTimestamp;

	@JsonProperty("deductibleCurrency")
	private String deductibleCurrency;

	@JsonProperty("productLocator")
	private String productLocator;

	@JsonProperty("lumpSumPaymentCurrency")
	private String lumpSumPaymentCurrency;

	@JsonProperty("premiumCurrency")
	private String premiumCurrency;

	@JsonProperty("policyholderLocator")
	private String policyholderLocator;

	@JsonProperty("policyLocator")
	private String policyLocator;

	@JsonProperty("policyCharacteristicsLocator")
	private String policyCharacteristicsLocator;

	@JsonProperty("locator")
	private String locator;

	@JsonProperty("coverageStartTimestamp")
	private String coverageStartTimestamp;

	public void setIndemnityInAggregateCurrency(String indemnityInAggregateCurrency){
		this.indemnityInAggregateCurrency = indemnityInAggregateCurrency;
	}

	public String getIndemnityInAggregateCurrency(){
		return indemnityInAggregateCurrency;
	}

	public void setFieldGroupsByLocator(FieldGroupsByLocator fieldGroupsByLocator){
		this.fieldGroupsByLocator = fieldGroupsByLocator;
	}

	public FieldGroupsByLocator getFieldGroupsByLocator(){
		return fieldGroupsByLocator;
	}

	public void setIndemnityPerItemCurrency(String indemnityPerItemCurrency){
		this.indemnityPerItemCurrency = indemnityPerItemCurrency;
	}

	public String getIndemnityPerItemCurrency(){
		return indemnityPerItemCurrency;
	}

	public void setMediaByLocator(MediaByLocator mediaByLocator){
		this.mediaByLocator = mediaByLocator;
	}

	public MediaByLocator getMediaByLocator(){
		return mediaByLocator;
	}

	public void setCreatedTimestamp(String createdTimestamp){
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedTimestamp(){
		return createdTimestamp;
	}

	public void setIndemnityPerEventCurrency(String indemnityPerEventCurrency){
		this.indemnityPerEventCurrency = indemnityPerEventCurrency;
	}

	public String getIndemnityPerEventCurrency(){
		return indemnityPerEventCurrency;
	}

	public void setPerilLocator(String perilLocator){
		this.perilLocator = perilLocator;
	}

	public String getPerilLocator(){
		return perilLocator;
	}

	public void setFieldValues(FieldValues fieldValues){
		this.fieldValues = fieldValues;
	}

	public FieldValues getFieldValues(){
		return fieldValues;
	}

	public void setUpdatedTimestamp(String updatedTimestamp){
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUpdatedTimestamp(){
		return updatedTimestamp;
	}

	public void setExposureCharacteristicsLocator(String exposureCharacteristicsLocator){
		this.exposureCharacteristicsLocator = exposureCharacteristicsLocator;
	}

	public String getExposureCharacteristicsLocator(){
		return exposureCharacteristicsLocator;
	}

	public void setPolicyModificationLocator(String policyModificationLocator){
		this.policyModificationLocator = policyModificationLocator;
	}

	public String getPolicyModificationLocator(){
		return policyModificationLocator;
	}

	public void setCoverageEndTimestamp(String coverageEndTimestamp){
		this.coverageEndTimestamp = coverageEndTimestamp;
	}

	public String getCoverageEndTimestamp(){
		return coverageEndTimestamp;
	}

	public void setDeductibleCurrency(String deductibleCurrency){
		this.deductibleCurrency = deductibleCurrency;
	}

	public String getDeductibleCurrency(){
		return deductibleCurrency;
	}

	public void setProductLocator(String productLocator){
		this.productLocator = productLocator;
	}

	public String getProductLocator(){
		return productLocator;
	}

	public void setLumpSumPaymentCurrency(String lumpSumPaymentCurrency){
		this.lumpSumPaymentCurrency = lumpSumPaymentCurrency;
	}

	public String getLumpSumPaymentCurrency(){
		return lumpSumPaymentCurrency;
	}

	public void setPremiumCurrency(String premiumCurrency){
		this.premiumCurrency = premiumCurrency;
	}

	public String getPremiumCurrency(){
		return premiumCurrency;
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

	public void setPolicyCharacteristicsLocator(String policyCharacteristicsLocator){
		this.policyCharacteristicsLocator = policyCharacteristicsLocator;
	}

	public String getPolicyCharacteristicsLocator(){
		return policyCharacteristicsLocator;
	}

	public void setLocator(String locator){
		this.locator = locator;
	}

	public String getLocator(){
		return locator;
	}

	public void setCoverageStartTimestamp(String coverageStartTimestamp){
		this.coverageStartTimestamp = coverageStartTimestamp;
	}

	public String getCoverageStartTimestamp(){
		return coverageStartTimestamp;
	}
}