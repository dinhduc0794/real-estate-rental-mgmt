package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse toBuildingResponse(BuildingEntity et){
        BuildingSearchResponse buildingSearch = modelMapper.map(et, BuildingSearchResponse.class);
        String districtName = DistrictCode.type().getOrDefault(et.getDistrict(), et.getDistrict());
        buildingSearch.setAddress(et.getStreet() + ", " + et.getWard() + ", " + districtName);
        List<RentAreaEntity> rentAreas = et.getRentAreaEntities();
        if(rentAreas != null){
            String rentArea = rentAreas.stream()
                                .map(it->it.getValue().toString())
                                .collect(Collectors.joining(", "));
            buildingSearch.setRentArea(rentArea);
        }
        return buildingSearch;
    }
}