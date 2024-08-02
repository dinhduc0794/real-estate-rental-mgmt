package com.javaweb.dto.response;

public class BuildingResponseDTO {
	// can tra ra cai gi thi can co field do
	private String name;
	private String address; // bang buiilding ko co, ket hop street, ward, district
	private Long numberOfBasement;
	private String managerName;
	private String managerPhone;
	private Long floorArea;
	private Long vacantArea; // dien tich trong
	private Long rentArea;
	private Long rentPrice;
	private String serviceFee;
	private Double brokerageFee;
	private String typeCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public Long getVacantArea() {
		return vacantArea;
	}

	public void setVacantArea(Long vacantArea) {
		this.vacantArea = vacantArea;
	}

	public Long getRentArea() {
		return rentArea;
	}

	public void setRentArea(Long rentArea) {
		this.rentArea = rentArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Double getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Double brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}
