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
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
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
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
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
	public void saveBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		if (buildingDTO.getId() != null) {
			buildingEntity = buildingRepository.findById(buildingDTO.getId()).get();
			rentAreaRepository.deleteAllByBuildingEntity(buildingEntity);
		}
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setNumberOfBasement(buildingDTO.getNumberOfBasement());
		DistrictEntity districtEntity = districtRepository.findById(buildingDTO.getDistrictId()).get();
		buildingEntity.setDistrict(districtEntity);
		buildingEntity.setRentPrice(20L);
		buildingEntity.setManagerName(buildingDTO.getManagerName());
		buildingEntity.setManagerPhone(buildingDTO.getManagerPhone());
//		List<RentAreaEntity> areaEntities = new ArrayList<RentAreaEntity>();
		buildingRepository.save(buildingEntity);
		for (Long value : buildingDTO.getRentAreas()) {
			RentAreaEntity areaEntity = new RentAreaEntity();
			areaEntity.setBuildingEntity(buildingEntity);
			areaEntity.setValue(value);
			rentAreaRepository.save(areaEntity);
		}
	}
	
	@Override
	public void deleteBuilding(Long[] ids) {
		// ok but bad performance 
//		for (Long id : ids) {
//			buildingRepository.deleteById(id);
//		}
		List<BuildingEntity> buildingEntities = buildingRepository.findByIdIn(ids);
		rentAreaRepository.deleteAllByBuildingEntityIn(buildingEntities);
		buildingRepository.deleteByIdIn(ids);
	}
}
