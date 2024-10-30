package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> typeCodes);
    BuildingDTO findById(Long id);
    ResponseDTO createOrUpdate(BuildingDTO buildingDTO);
    ResponseDTO deleteBuildings(List<Long> buildingIds);
    ResponseDTO updateAssignmentModal(AssignmentBuildingDTO assignmentBuildingDTO);
    ResponseDTO findStaffsByBuildingId(Long id);
}
