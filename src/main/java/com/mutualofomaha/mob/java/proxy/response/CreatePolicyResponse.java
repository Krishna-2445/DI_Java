package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreatePolicyResponse {

	@JsonProperty("characteristics")
	private List<CharacteristicsItem> characteristics;

	@JsonProperty("fees")
	private List<Object> fees;

	@JsonProperty("grossFees")
	private String grossFees;

	@JsonProperty("documents")
	private List<Object> documents;

	@JsonProperty("createdTimestamp")
	private String createdTimestamp;

	@JsonProperty("originalContractStartTimestamp")
	private String originalContractStartTimestamp;

	@JsonProperty("paymentScheduleName")
	private String paymentScheduleName;

	@JsonProperty("updatedTimestamp")
	private String updatedTimestamp;

	@JsonProperty("productName")
	private String productName;

	@JsonProperty("exposures")
	private List<ExposuresItem> exposures;

	@JsonProperty("effectiveContractEndTimestamp")
	private String effectiveContractEndTimestamp;

	@JsonProperty("invoices")
	private List<Object> invoices;

	@JsonProperty("productLocator")
	private String productLocator;

	@JsonProperty("policyholderLocator")
	private String policyholderLocator;

	@JsonProperty("originalContractEndTimestamp")
	private String originalContractEndTimestamp;

	@JsonProperty("grossFeesCurrency")
	private String grossFeesCurrency;

	@JsonProperty("displayId")
	private String displayId;

	@JsonProperty("locator")
	private String locator;

	@JsonProperty("modifications")
	private List<ModificationsItem> modifications;

	public void setCharacteristics(List<CharacteristicsItem> characteristics){
		this.characteristics = characteristics;
	}

	public List<CharacteristicsItem> getCharacteristics(){
		return characteristics;
	}

	public void setFees(List<Object> fees){
		this.fees = fees;
	}

	public List<Object> getFees(){
		return fees;
	}

	public void setGrossFees(String grossFees){
		this.grossFees = grossFees;
	}

	public String getGrossFees(){
		return grossFees;
	}

	public void setDocuments(List<Object> documents){
		this.documents = documents;
	}

	public List<Object> getDocuments(){
		return documents;
	}

	public void setCreatedTimestamp(String createdTimestamp){
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedTimestamp(){
		return createdTimestamp;
	}

	public void setOriginalContractStartTimestamp(String originalContractStartTimestamp){
		this.originalContractStartTimestamp = originalContractStartTimestamp;
	}

	public String getOriginalContractStartTimestamp(){
		return originalContractStartTimestamp;
	}

	public void setPaymentScheduleName(String paymentScheduleName){
		this.paymentScheduleName = paymentScheduleName;
	}

	public String getPaymentScheduleName(){
		return paymentScheduleName;
	}

	public void setUpdatedTimestamp(String updatedTimestamp){
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUpdatedTimestamp(){
		return updatedTimestamp;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setExposures(List<ExposuresItem> exposures){
		this.exposures = exposures;
	}

	public List<ExposuresItem> getExposures(){
		return exposures;
	}

	public void setEffectiveContractEndTimestamp(String effectiveContractEndTimestamp){
		this.effectiveContractEndTimestamp = effectiveContractEndTimestamp;
	}

	public String getEffectiveContractEndTimestamp(){
		return effectiveContractEndTimestamp;
	}

	public void setInvoices(List<Object> invoices){
		this.invoices = invoices;
	}

	public List<Object> getInvoices(){
		return invoices;
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

	public void setOriginalContractEndTimestamp(String originalContractEndTimestamp){
		this.originalContractEndTimestamp = originalContractEndTimestamp;
	}

	public String getOriginalContractEndTimestamp(){
		return originalContractEndTimestamp;
	}

	public void setGrossFeesCurrency(String grossFeesCurrency){
		this.grossFeesCurrency = grossFeesCurrency;
	}

	public String getGrossFeesCurrency(){
		return grossFeesCurrency;
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

	public void setModifications(List<ModificationsItem> modifications){
		this.modifications = modifications;
	}

	public List<ModificationsItem> getModifications(){
		return modifications;
	}
}