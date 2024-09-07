package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingConverter buildingDTOConverter;
	
	@Autowired
	private BuildingSearchBuilderConverter builderConverter;

	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCodes) {
		BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(params, typeCodes);
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder);
		
		List<BuildingResponseDTO> buildingResponseDTOs = new ArrayList<BuildingResponseDTO>();

		// lặp qua từng Entity để filter từng thằng
		for (BuildingEntity it : buildingEntities) {
			// filter data response
			buildingResponseDTOs.add(buildingDTOConverter.toBuildingResponseDTO(it));

		}
		return buildingResponseDTOs;
	}
	
	
}
