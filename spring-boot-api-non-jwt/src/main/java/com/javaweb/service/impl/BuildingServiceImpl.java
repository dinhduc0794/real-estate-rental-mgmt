package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<BuildingResponseDTO> findAll(String name, String ward) {
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, ward);
		//done
		List<BuildingResponseDTO> buildingResponseDTOs = new ArrayList<BuildingResponseDTO>();

		// lặp qua từng Entity để filter từng thằng
		for (BuildingEntity it : buildingEntities) {
			// filter data response
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			buildingResponseDTO.setId(it.getId());
			buildingResponseDTO.setName(it.getName());
			buildingResponseDTO.setAddress(it.getStreet() + ", " + it.getWard() + ", " + it.getDistrictId());

			buildingResponseDTOs.add(buildingResponseDTO);

		}
		return buildingResponseDTOs;
	}
}
