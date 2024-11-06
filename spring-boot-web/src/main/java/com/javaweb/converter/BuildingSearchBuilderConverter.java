package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MappingUtils;
import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MappingUtils;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest params) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MappingUtils.getObject(params.getName(), String.class))
                .setFloorArea(MappingUtils.getObject(params.getFloorArea(), Long.class))
                .setDistrict(MappingUtils.getObject(params.getDistrict(), String.class))
                .setWard(MappingUtils.getObject(params.getWard(), String.class))
                .setStreet(MappingUtils.getObject(params.getStreet(), String.class))
                .setNumberOfBasement(MappingUtils.getObject(params.getNumberOfBasement(), Long.class))
                .setDirection(MappingUtils.getObject(params.getDirection(), String.class))
                .setLevel(MappingUtils.getObject(params.getLevel(), String.class))
                .setManagerName(MappingUtils.getObject(params.getManagerName(), String.class))
                .setManagerPhone(MappingUtils.getObject(params.getManagerPhone(), String.class))
                .setRentAreaFrom(MappingUtils.getObject(params.getRentAreaFrom(), Long.class))
                .setRentAreaTo(MappingUtils.getObject(params.getRentAreaTo(), Long.class))
                .setRentPriceFrom(MappingUtils.getObject(params.getRentPriceFrom(), Long.class))
                .setRentPriceTo(MappingUtils.getObject(params.getRentPriceTo(), Long.class))
                .setStaffId(MappingUtils.getObject(params.getStaffId(), Long.class))
                .setTypeCode(params.getTypeCode())
                .build();
        return buildingSearchBuilder;
    }
}
