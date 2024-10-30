package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private BuildingDTOConverter buildingDTOConverter;
    @Autowired
    private BuildingSearchBuilderConverter builderConverter;

    @Override
    public List <BuildingSearchResponse> findAll(Map<String, Object> params, List<String> typeCodes){
        BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(params, typeCodes);
        List <BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder);
        List<BuildingSearchResponse> buildingResponse = new ArrayList<>();
        for(BuildingEntity ent : buildingEntities){
            buildingResponse.add(buildingDTOConverter.toBuildingResponse(ent));
        }
        return buildingResponse;
    }

    @Override
    public BuildingDTO findById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
            BuildingDTO buildingDTO = buildingDTOConverter.toBuildingDTO(buildingEntity);
        return buildingDTO;
    }

    @Override
    public ResponseDTO createOrUpdate(BuildingDTO buildingDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        BuildingEntity buildingEntity = buildingDTOConverter.toBuildingEntity(buildingDTO);
        if (buildingEntity.getId() != null && buildingRepository.existsById(buildingEntity.getId())) {
            responseDTO.setMessage("Cập nhật thành công");
        }
        else responseDTO.setMessage("Thêm thành công");
        buildingRepository.save(buildingEntity);
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteBuildings(List<Long> buildingIds) {
        rentAreaRepository.deleteByBuilding_IdIn(buildingIds);
        buildingRepository.deleteAllByIdIn(buildingIds);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Xóa thành công");
        return responseDTO;
    }
}
