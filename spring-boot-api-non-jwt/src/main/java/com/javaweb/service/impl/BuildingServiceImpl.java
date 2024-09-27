package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.service.BuildingService;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	
	@Autowired
	private BuildingSearchBuilderConverter builderConverter;
	
	@PersistenceContext
	private EntityManager entityManager;

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

	@Override
	public void createBuilding(BuildingDTO buildingDTO) {
		// TODO Auto-generated method stub
		BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, buildingDTO.getId());
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setNumberOfBasement(buildingDTO.getNumberOfBasement());
		DistrictEntity districtEntity = entityManager.find(DistrictEntity.class, buildingDTO.getDistrictId());
		buildingEntity.setDistrict(districtEntity);
		buildingEntity.setRentPrice(20L);
		entityManager.merge(buildingEntity);
	}
}
