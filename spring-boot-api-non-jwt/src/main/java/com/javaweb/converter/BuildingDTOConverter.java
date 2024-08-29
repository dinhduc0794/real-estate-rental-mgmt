package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;

	public BuildingResponseDTO toBuildingResponseDTO(BuildingEntity buildingEntity) {
		BuildingResponseDTO buildingResponseDTO = modelMapper.map(buildingEntity, BuildingResponseDTO.class);
		//name district
		DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistrictId());
		
		//string values rentarea
		List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuildingId(buildingEntity.getId());
		String rentAreaValues = rentAreaValueToString(rentAreaEntities);
		
		// buildingResponseDTO.setName(buildingEntity.getName());
		buildingResponseDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtEntity.getName());
		// buildingResponseDTO.setNumberOfBasement(buildingEntity.getNumberOfBasement());
		// buildingResponseDTO.setManagerName(buildingEntity.getManagerName());
		// buildingResponseDTO.setManagerPhone(buildingEntity.getManagerPhone());
		// buildingResponseDTO.setFloorArea(buildingEntity.getFloorArea());
		buildingResponseDTO.setVacantArea(null);
		buildingResponseDTO.setRentArea(rentAreaValues);
		// buildingResponseDTO.setRentPrice(buildingEntity.getRentPrice());	
		// buildingResponseDTO.setServiceFee(buildingEntity.getServiceFee());
		// buildingResponseDTO.setBrokerageFee(buildingEntity.getBrokerageFee());

		return buildingResponseDTO;
	}
	
	public String rentAreaValueToString(List<RentAreaEntity> rentAreaEntities) {
		return rentAreaEntities.stream()
                .map(it -> it.getValue().toString())
                .collect(Collectors.joining(", "));
	}

//	public static String rentAreaValueToString(List<RentAreaEntity> raEntities) {
//		StringBuilder rentAreaValues = new StringBuilder();
//        for (RentAreaEntity it : raEntities) {
//            rentAreaValues.append(it.getValue()).append(", ");
//        }
//
//        String result = rentAreaValues.toString();
//        
//        //bo dau phay va space o cuoi
//        if (result.length() > 0) {
//            result = result.substring(0, result.length() - 2); 
//        }
//
//        return result;
//	}	
}
	