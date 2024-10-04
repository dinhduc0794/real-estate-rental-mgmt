package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long floorArea;
	private Long districtId;
	private String ward;
	private String street;
	private Long numberOfBasement;
	private String direction;
	private String level;
	private String managerName;
	private String managerPhone;
	private Long vacantArea; // dien tich trong
	private Long rentAreaFrom;
	private Long rentAreaTo;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long staffId;
	private List<String> typeCode = new ArrayList<>();
	
	private BuildingSearchBuilder(Builder builder){
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.ward = builder.ward;
        this.street = builder.street;
        this.districtId = builder.districtId;
        this.numberOfBasement = builder.numberOfBasement;
        this.level = builder.level;
        this.direction = builder.direction;
        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.rentAreaFrom = builder.rentAreaFrom;
        this.rentAreaTo = builder.rentAreaTo;
        this.staffId = builder.staffId;
        this.typeCode = builder.typeCode;
    }
	
	public String getName() {
		return name;
	}
	public Long getFloorArea() {	  
		return floorArea;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public String getLevel() {
		return level;
	}
	public String getManagerName() {
		return managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public Long getVacantArea() {
		return vacantArea;
	}
	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}
	public Long getRentAreaTo() {
		return rentAreaTo;
	}
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public Long getStaffId() {
		return staffId;
	}
	public List<String> getTypeCode() {
		return typeCode;
	}
	
	public static class Builder{
		private String name;
		private Long floorArea;
		private Long districtId;
		private String ward;
		private String street;
		private Long numberOfBasement;
		private String direction;
		private String level;
		private String managerName;
		private String managerPhone;
		private Long vacantArea; // dien tich trong
		private Long rentAreaFrom;
		private Long rentAreaTo;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long staffId;
		private List<String> typeCode = new ArrayList<>();
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}
		public Builder setManagerPhone(String managerPhone) {
			this.managerPhone = managerPhone;
			return this;
		}
		public Builder setVacantArea(Long vacantArea) {
			this.vacantArea = vacantArea;
			return this;
		}
		public Builder setRentAreaFrom(Long rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}
		public Builder setRentAreaTo(Long rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}
		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		public Builder setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}
		
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}	
	}
}
