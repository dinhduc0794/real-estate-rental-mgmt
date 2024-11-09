package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(BuildingSearchRequest params, Pageable pageable);
    BuildingDTO findById(Long id);
    ResponseDTO createOrUpdate(BuildingDTO buildingDTO);
    ResponseDTO deleteBuildings(List<Long> buildingIds);
    ResponseDTO updateAssignmentModal(AssignmentBuildingDTO assignmentBuildingDTO);
    ResponseDTO findStaffsByBuildingId(Long id);
    int countTotalItems(BuildingSearchRequest params);
    void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity);
}
