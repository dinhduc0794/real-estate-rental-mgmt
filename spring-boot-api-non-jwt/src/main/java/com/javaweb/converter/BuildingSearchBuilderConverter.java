package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MappingUtil;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCodes) {
    	BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder() 
																			.setName(MappingUtil.getObject(params, "name", String.class))
																			.setFloorArea(MappingUtil.getObject(params, "floorArea", Long.class))
																			.setDistrictId(MappingUtil.getObject(params, "districtId", Long.class))
																			.setWard(MappingUtil.getObject(params, "ward", String.class))
																			.setStreet(MappingUtil.getObject(params, "street", String.class))
																			.setNumberOfBasement(MappingUtil.getObject(params, "numberOfBasement", Long.class))
																			.setDirection(MappingUtil.getObject(params, "direction", String.class))
																			.setLevel(MappingUtil.getObject(params, "level", String.class))
																			.setManagerName(MappingUtil.getObject(params, "managerName", String.class))
																			.setManagerPhone(MappingUtil.getObject(params, "managerPhone", String.class))
																			.setVacantArea(MappingUtil.getObject(params, "vacantArea", Long.class))
																			.setRentAreaFrom(MappingUtil.getObject(params, "rentAreaFrom", Long.class))
																			.setRentAreaTo(MappingUtil.getObject(params, "rentAreaTo", Long.class))
																			.setRentPriceFrom(MappingUtil.getObject(params, "rentPriceFrom", Long.class))
																			.setRentPriceTo(MappingUtil.getObject(params, "rentPriceTo", Long.class))
																			.setStaffId(MappingUtil.getObject(params, "staffId", Long.class))
																			.setTypeCode(typeCodes)
																			.build();
    	return buildingSearchBuilder;
    }
}
