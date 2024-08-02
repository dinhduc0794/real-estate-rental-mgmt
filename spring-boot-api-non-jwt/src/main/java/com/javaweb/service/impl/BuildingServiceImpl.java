package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCodes) {
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCodes);
		
		List<BuildingResponseDTO> buildingResponseDTOs = new ArrayList<BuildingResponseDTO>();

		// lặp qua từng Entity để filter từng thằng
		for (BuildingEntity it : buildingEntities) {
			// filter data response
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			
			//name district
			DistrictEntity districtEntity = districtRepository.findDistrictById(it.getDistrictId());
			
			//string values rentarea
			List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findRentAreaByBuildingId(it.getId());
			String rentAreaValues = rentAreaValues(rentAreaEntities);

			buildingResponseDTO.setName(it.getName());
			buildingResponseDTO.setAddress(it.getStreet() + ", " + it.getWard() + ", " + districtEntity.getName());
			buildingResponseDTO.setNumberOfBasement(it.getNumberOfBasement());
			buildingResponseDTO.setManagerName(it.getManagerName());
			buildingResponseDTO.setManagerPhone(it.getManagerPhone());
			buildingResponseDTO.setFloorArea(it.getFloorArea());
			buildingResponseDTO.setVacantArea(null);
			buildingResponseDTO.setRentArea(rentAreaValues);
			buildingResponseDTO.setRentPrice(it.getRentPrice());
			buildingResponseDTO.setServiceFee(it.getServiceFee());
			buildingResponseDTO.setBrokerageFee(it.getBrokerageFee());

			buildingResponseDTOs.add(buildingResponseDTO);

		}
		return buildingResponseDTOs;
	}
	
	public static String rentAreaValues(List<RentAreaEntity> raEntities) {
		StringBuilder rentAreaValues = new StringBuilder();
        for (RentAreaEntity it : raEntities) {
            rentAreaValues.append(it.getValue()).append(", ");
        }

        String result = rentAreaValues.toString();
        
        //bo dau phay va space o cuoi
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 2); 
        }

        return result;
	}	
}


//private String name;
//private String address; // bang buiilding ko co, ket hop street, ward, district
//private Long numberOfBasement;
//private String managerName;
//private String managerPhone;
//private Long floorArea;
//private Long vacantArea; // dien tich trong
//private Long rentArea;
//private Long rentPrice;
//private String serviceFee;
//private Double brokerageFee;
