package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    private  UserRepository userRepository;
    @Autowired
    private BuildingDTOConverter buildingDTOConverter;
    @Autowired
    private BuildingSearchBuilderConverter builderConverter;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Override
    public List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> typeCodes){
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

        if (buildingEntity.getId() != null) {
            // Cap nhat toa nha da ton tai
            List<AssignmentBuildingEntity> assignmentBuildingEntities = buildingEntity.getAssignmentBuildingEntities();
            for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntities) {
                assignmentBuildingEntity.setBuilding(buildingEntity);
            }

            // Xoa dien tich thue cu truoc khi cap nhat
            rentAreaRepository.deleteByBuilding_Id(buildingEntity.getId());

            responseDTO.setMessage("Cập nhật tòa nhà thành công");
        }
        else {
            // Toa nha moi thi luu truc tiep
            responseDTO.setMessage("Thêm tòa nhà thành công");
            assignmentBuildingRepository.saveAll(buildingEntity.getAssignmentBuildingEntities());
        }

        buildingRepository.save(buildingEntity);
        rentAreaRepository.saveAll(buildingEntity.getRentAreaEntities());

        return responseDTO;
    }

    @Override
    public ResponseDTO deleteBuildings(List<Long> buildingIds) {
        // Xoa tat ca giao toa nha de tranh bi loi khoa ngoai (ko the xoa sau khi giao toa nha)
        assignmentBuildingRepository.deleteByBuilding_IdIn(buildingIds);
        rentAreaRepository.deleteByBuilding_IdIn(buildingIds);

        // Xoa toa nha
        buildingRepository.deleteAllByIdIn(buildingIds);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Xóa thành công");
        return responseDTO;
    }


    @Override
    public ResponseDTO findStaffsByBuildingId(Long id) {
        //nho' keo xuong Service de xu li
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");

        // lay ra buildingEntity tuong ung voi id -> lay ra 1 list userEntity role Staff dang quan li toa nha hien tai
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        List<AssignmentBuildingEntity> assignmentBuildingEntities = buildingEntity.getAssignmentBuildingEntities();

        List<UserEntity> assignedStaffs = new ArrayList<>();
        for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntities) {
            assignedStaffs.add(assignmentBuildingEntity.getStaff());
        }

        List<StaffResponseDTO> staffResponseDTOs = new ArrayList<>();
        for (UserEntity staff : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setStaffId(staff.getId());
            staffResponseDTO.setUserName(staff.getUserName());
            if (assignedStaffs.contains(staff)) {
                staffResponseDTO.setChecked("checked");
            }
            else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOs.add(staffResponseDTO);
        }

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOs);
        responseDTO.setMessage("success");
        return responseDTO;
    }

    @Override
    public ResponseDTO updateAssignmentModal(AssignmentBuildingDTO assignmentBuildingDTO) {
        Long buildingId = assignmentBuildingDTO.getBuildingId();
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();

        // Xoá danh sách giao tòa nhà cũ
        assignmentBuildingRepository.deleteByBuildingId(buildingId);

        List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<>();
        List<UserEntity> staffs = userRepository.findByIdIn(assignmentBuildingDTO.getStaffIds());
        for (UserEntity staff : staffs) {
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            assignmentBuildingEntity.setBuilding(buildingEntity);
            assignmentBuildingEntity.setStaff(staff);
            assignmentBuildingEntities.add(assignmentBuildingEntity);
        }

        assignmentBuildingRepository.saveAll(assignmentBuildingEntities);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Giao tòa nhà cho nhân viên thành công");
        return responseDTO;
    }
//    @Override
//    public ResponseDTO updateAssignmentModal(AssignmentBuildingDTO assignmentBuildingDTO) {
//        List<Long> staffIds = assignmentBuildingDTO.getStaffIds();
//
//        Long buildingId = assignmentBuildingDTO.getBuildingId();
//        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
//
//        List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<>();
//
//        // Xoa danh sach giao toa nha cu
//        assignmentBuildingRepository.deleteByBuildingId(buildingId);
//
//        // Tao danh sach giao toa nha moi
//        for (Long staffId : staffIds) {
//            UserEntity staff = userRepository.findById(staffId).get();
//            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
//            assignmentBuildingEntity.setBuilding(buildingEntity);
//            assignmentBuildingEntity.setStaff(staff);
//            assignmentBuildingEntities.add(assignmentBuildingEntity);
//            assignmentBuildingRepository.save(assignmentBuildingEntity);
//        }
//
//        buildingEntity.setAssignmentBuildingEntities(assignmentBuildingEntities);
//        buildingRepository.save(buildingEntity);
//
//
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setMessage("Giao tòa nhà cho nhân viên thành công");
//        return responseDTO;
//    }
}
