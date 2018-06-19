package com.mutualofomaha.mob.java.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class FieldValues{

	@JsonProperty("income")
	private List<String> income;

	@JsonProperty("hospitalized")
	private List<String> hospitalized;

	@JsonProperty("height_ft")
	private List<String> heightFt;

	@JsonProperty("occupation")
	private List<String> occupation;

	@JsonProperty("gender")
	private List<String> gender;

	@JsonProperty("seen_doctor")
	private List<String> seenDoctor;

	@JsonProperty("dob")
	private List<String> dob;

	@JsonProperty("basemoben")
	private List<String> basemoben;

	@JsonProperty("height_inches")
	private List<String> heightInches;

	@JsonProperty("weight")
	private List<String> weight;

	@JsonProperty("diabetes")
	private List<String> diabetes;

	public void setIncome(List<String> income){
		this.income = income;
	}

	public List<String> getIncome(){
		return income;
	}

	public void setHospitalized(List<String> hospitalized){
		this.hospitalized = hospitalized;
	}

	public List<String> getHospitalized(){
		return hospitalized;
	}

	public void setHeightFt(List<String> heightFt){
		this.heightFt = heightFt;
	}

	public List<String> getHeightFt(){
		return heightFt;
	}

	public void setOccupation(List<String> occupation){
		this.occupation = occupation;
	}

	public List<String> getOccupation(){
		return occupation;
	}

	public void setGender(List<String> gender){
		this.gender = gender;
	}

	public List<String> getGender(){
		return gender;
	}

	public void setSeenDoctor(List<String> seenDoctor){
		this.seenDoctor = seenDoctor;
	}

	public List<String> getSeenDoctor(){
		return seenDoctor;
	}

	public void setDob(List<String> dob){
		this.dob = dob;
	}

	public List<String> getDob(){
		return dob;
	}

	public void setBasemoben(List<String> basemoben){
		this.basemoben = basemoben;
	}

	public List<String> getBasemoben(){
		return basemoben;
	}

	public void setHeightInches(List<String> heightInches){
		this.heightInches = heightInches;
	}

	public List<String> getHeightInches(){
		return heightInches;
	}

	public void setWeight(List<String> weight){
		this.weight = weight;
	}

	public List<String> getWeight(){
		return weight;
	}

	public void setDiabetes(List<String> diabetes){
		this.diabetes = diabetes;
	}

	public List<String> getDiabetes(){
		return diabetes;
	}
}