package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class ExposureModificationsItem{

	@JsonProperty("policyModificationLocator")
	private String policyModificationLocator;

	@JsonProperty("newExposureCharacteristicsLocator")
	private String newExposureCharacteristicsLocator;

	@JsonProperty("perilModifications")
	private List<PerilModificationsItem> perilModifications;

	@JsonProperty("productLocator")
	private String productLocator;

	@JsonProperty("policyholderLocator")
	private String policyholderLocator;

	@JsonProperty("policyLocator")
	private String policyLocator;

	@JsonProperty("locator")
	private String locator;

	@JsonProperty("exposureLocator")
	private String exposureLocator;

	public void setPolicyModificationLocator(String policyModificationLocator){
		this.policyModificationLocator = policyModificationLocator;
	}

	public String getPolicyModificationLocator(){
		return policyModificationLocator;
	}

	public void setNewExposureCharacteristicsLocator(String newExposureCharacteristicsLocator){
		this.newExposureCharacteristicsLocator = newExposureCharacteristicsLocator;
	}

	public String getNewExposureCharacteristicsLocator(){
		return newExposureCharacteristicsLocator;
	}

	public void setPerilModifications(List<PerilModificationsItem> perilModifications){
		this.perilModifications = perilModifications;
	}

	public List<PerilModificationsItem> getPerilModifications(){
		return perilModifications;
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

	public void setLocator(String locator){
		this.locator = locator;
	}

	public String getLocator(){
		return locator;
	}

	public void setExposureLocator(String exposureLocator){
		this.exposureLocator = exposureLocator;
	}

	public String getExposureLocator(){
		return exposureLocator;
	}
}