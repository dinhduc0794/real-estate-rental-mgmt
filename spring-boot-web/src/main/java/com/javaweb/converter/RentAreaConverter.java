package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentAreaConverter {
    List<RentAreaEntity> toListRentAreaEntity(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        if (buildingDTO.getRentArea() == null && buildingDTO.getRentArea().isEmpty()) return null;
        List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
        String[] rentAreas = buildingDTO.getRentArea().split(",");
        for (String rentArea : rentAreas) {
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            if (rentArea.trim().isEmpty()) continue;
            rentAreaEntity.setValue(Long.parseLong(rentArea.trim()));
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntities.add(rentAreaEntity);
        }
        return rentAreaEntities;
    }
}
