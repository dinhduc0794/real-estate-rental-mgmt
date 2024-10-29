package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import com.javaweb.utils.MappingUtils;
import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MappingUtils;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCodes) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MappingUtils.getObject(params, "name", String.class))
                .setFloorArea(MappingUtils.getObject(params, "floorArea", Long.class))
                .setDistrict(MappingUtils.getObject(params, "district", String.class))
                .setWard(MappingUtils.getObject(params, "ward", String.class))
                .setStreet(MappingUtils.getObject(params, "street", String.class))
                .setNumberOfBasement(MappingUtils.getObject(params, "numberOfBasement", Long.class))
                .setDirection(MappingUtils.getObject(params, "direction", String.class))
                .setLevel(MappingUtils.getObject(params, "level", String.class))
                .setManagerName(MappingUtils.getObject(params, "managerName", String.class))
                .setManagerPhone(MappingUtils.getObject(params, "managerPhone", String.class))
                .setRentAreaFrom(MappingUtils.getObject(params, "rentAreaFrom", Long.class))
                .setRentAreaTo(MappingUtils.getObject(params, "rentAreaTo", Long.class))
                .setRentPriceFrom(MappingUtils.getObject(params, "rentPriceFrom", Long.class))
                .setRentPriceTo(MappingUtils.getObject(params, "rentPriceTo", Long.class))
                .setStaffId(MappingUtils.getObject(params, "staffId", Long.class))
                .setTypeCode(typeCodes)
                .build();
        return buildingSearchBuilder;
    }
}
