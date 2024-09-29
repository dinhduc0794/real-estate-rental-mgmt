package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private ModelMapper modelMapper;

	public BuildingResponseDTO toBuildingResponseDTO(BuildingEntity et) {
		BuildingResponseDTO buildingResponseDTO = modelMapper.map(et, BuildingResponseDTO.class);	//2 tham so: source va destination class
		
		buildingResponseDTO.setAddress(et.getStreet() + ", " + et.getWard() + ", " + et.getDistrict().getName());		
		
		String rentArea = et.getRentAreaEntities().stream()
											.map(i -> i.getValue().toString()).collect(Collectors.joining(", "));
		buildingResponseDTO.setRentArea(rentArea);
		
		return buildingResponseDTO;
	}
	
	public BuildingEntity toBuildingEntity(BuildingDTO dto) {
		BuildingEntity buildingEntity = modelMapper.map(dto, BuildingEntity.class);
		return buildingEntity;
	}
}