package com.javaweb.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//DTO = Data Transfer Object
public class BuildingDTO {
	private Long id;
	private String name;
	private String ward;
	private String street;
	@JsonProperty("number_of_basement")
	private Long numberOfBasement;
	@JsonProperty("district_id")
	private Long districtId;
	private List<String> typeCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public List<String> getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(List<String> typeCode) {
		this.typeCode = typeCode;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
