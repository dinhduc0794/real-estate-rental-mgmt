package com.javaweb.dto.response;

public class BuildingResponseDTO {
	private Long id;
	private String name;
	private String address;		//bang buiilding ko co, ket hop street, ward, district

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
