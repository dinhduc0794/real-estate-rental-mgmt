package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.constant.SystemConstant;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private BuildingSearchBuilderConverter builderConverter;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest params, Pageable pageable) {
        BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(params);

        List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder, pageable);
        List<BuildingSearchResponse> buildingResponses = new ArrayList<>();
        for (BuildingEntity ent : buildingEntities) {
            buildingResponses.add(buildingConverter.toBuildingResponse(ent));
        }
        return buildingResponses;
    }

    @Override
    public BuildingDTO findById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        BuildingDTO buildingDTO = buildingConverter.toBuildingDTO(buildingEntity);
        return buildingDTO;
    }

    @Override
    public boolean isStaffOfBuilding(Long staffId, Long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
        UserEntity staff = userRepository.findById(staffId).get();
        if (buildingEntity.getStaffList().contains(staff)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ResponseDTO createOrUpdate(BuildingDTO buildingDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(buildingDTO);

        if (buildingEntity.getId() != null) {
            BuildingEntity buildingEntityOld = buildingRepository.findById(buildingEntity.getId()).get();
            if (buildingEntityOld.getImage() != null && !buildingEntityOld.getImage().isEmpty()) {
                buildingEntity.setImage(buildingEntityOld.getImage());
            }

            responseDTO.setMessage("Cập nhật tòa nhà thành công");
        } else {
            // Toa nha moi thi luu truc tiep
            responseDTO.setMessage("Thêm tòa nhà thành công");
        }

        saveThumbnail(buildingDTO, buildingEntity);
        buildingRepository.save(buildingEntity);

        return responseDTO;
    }

    @Override
    public ResponseDTO deleteBuildings(List<Long> buildingIds) {
        // Khi chua su dung cascade, muon xoa building thi phai xoa building trong bang rentarea va assignmentbuilding truoc
        // vi 2 bang nay co tham chieu den building theo quan he 1-n (1 building co nhieu rentarea va assignmentbuilding)
//        assignmentBuildingRepository.deleteByBuilding_IdIn(buildingIds);
//        rentAreaRepository.deleteByBuilding_IdIn(buildingIds);

        // Xoa toa nha
        buildingRepository.deleteAllByIdIn(buildingIds);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Xóa thành công");
        return responseDTO;
    }

    @Override
    public ResponseDTO updateAssignmentModal(AssignmentBuildingDTO assignmentBuildingDTO) {
        Long buildingId = assignmentBuildingDTO.getBuildingId();
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();

        List<UserEntity> assignedStaffs = userRepository.findByIdIn(assignmentBuildingDTO.getStaffIds());
        buildingEntity.setStaffList(assignedStaffs);

        buildingRepository.save(buildingEntity);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Giao tòa nhà cho nhân viên thành công");
        return responseDTO;
    }

    @Override
    public int countTotalItems(BuildingSearchRequest params) {
        return buildingRepository.countTotalItems(builderConverter.toBuildingSearchBuilder(params));
    }

    @Override
    public void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage() && !path.equals(buildingEntity.getImage())) {
                File oldFile = new File(SystemConstant.IMAGE_PATH + buildingEntity.getImage());
                oldFile.delete();
            }

            String base64 = buildingDTO.getImageBase64();
            if (base64.contains(",")) {
                base64 = base64.split(",")[1];

                byte[] bytes = Base64.decodeBase64(base64.getBytes(StandardCharsets.UTF_8));
                uploadFileUtils.writeOrUpdate(path, bytes);
                buildingEntity.setImage(path);
            }
        }
    }
}
