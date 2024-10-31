package com.javaweb.converter;

import java.util.ArrayList;
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
    @Autowired
    private RentAreaConverter rentAreaConverter;

    public BuildingSearchResponse toBuildingResponse(BuildingEntity ent){
        BuildingSearchResponse buildingSearch = modelMapper.map(ent, BuildingSearchResponse.class);

        String districtName = DistrictCode.type().getOrDefault(ent.getDistrict(), ent.getDistrict());
        buildingSearch.setAddress(ent.getStreet() + ", " + ent.getWard() + ", " + districtName);

        List<RentAreaEntity> rentAreaEntities = ent.getRentAreaEntities();
        if(rentAreaEntities != null){
            String rentArea = rentAreaEntities.stream()
                                .map(it->it.getValue().toString())
                                .collect(Collectors.joining(", "));
            buildingSearch.setRentArea(rentArea);
        }
        return buildingSearch;
    }

    public BuildingEntity toBuildingEntity(BuildingDTO buildingDTO){
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);

        List<RentAreaEntity> rentAreaEntities = rentAreaConverter.toListRentAreaEntity(buildingDTO, buildingEntity);
        buildingEntity.setRentAreaEntities(rentAreaEntities);

        String typeCodeStr = buildingDTO.getTypeCodes().stream().map(it->it.toString()).collect(Collectors.joining(","));
        buildingEntity.setTypeCode(typeCodeStr);

        return buildingEntity;
    }

    public BuildingDTO toBuildingDTO(BuildingEntity ent) {
        BuildingDTO buildingDTO = modelMapper.map(ent, BuildingDTO.class);

        List<String> typeCodes = new ArrayList<>();
        if(ent.getTypeCode() != null){
            String[] strTypes = ent.getTypeCode().split(",");
            for(String type : strTypes){
                typeCodes.add(type);
            }
        }
        buildingDTO.setTypeCodes(typeCodes);

        List<RentAreaEntity> rentAreaEntities = ent.getRentAreaEntities();
        if(rentAreaEntities != null){
            String rentArea = rentAreaEntities.stream()
                    .map(it->it.getValue().toString())
                    .collect(Collectors.joining(", "));
            buildingDTO.setRentArea(rentArea);
        }
        return buildingDTO;
    }
}