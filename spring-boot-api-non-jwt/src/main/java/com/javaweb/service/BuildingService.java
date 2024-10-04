package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;

public interface BuildingService {
	List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCodes);
	void saveBuilding(BuildingDTO buildingDTO);
	void deleteBuilding(Long[] ids);
}
	