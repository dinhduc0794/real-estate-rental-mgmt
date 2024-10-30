package com.javaweb.api.admin;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.service.BuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(("/api/buildings"))
public class BuildingAPI {
    @Autowired
    private IUserService userService;
    @Autowired
    private BuildingService buildingService;

    @PostMapping
    private ResponseEntity<?> createOrUpdateBuilding(@Valid @RequestBody BuildingDTO buildingDTO,
                                                  BindingResult bindingResult) {
        try{
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());

                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setMessage("Validation failed");
                responseDTO.setDetail(errorMessages);
                return ResponseEntity.badRequest().body(responseDTO);
            }
            // neu dung thi //xuong service -> xuong repo -> save vao db
            ResponseDTO responseDTO = buildingService.createOrUpdate(buildingDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    private Object loadStaff(@PathVariable Long id) {
        //nho' keo xuong Service de xu li
        List<UserEntity> listStaff = userService.listStaff();

        // lay ra buildingEntity tuong ung voi id -> lay ra 1 list userEntity role Staff dang quan li toa nha hien tai
        List<UserEntity> assignedStaffs = new ArrayList<>();

        List<StaffResponseDTO> staffResponseDTOs = new ArrayList<>();
        for (UserEntity staff : listStaff) {
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
        responseDTO.setMessage("Success");

        return responseDTO;
    }

    @PutMapping("/staffs")
    private Object updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        return new String("OK");
    }

    @DeleteMapping("/{ids}")
    private ResponseDTO deleteBuilding(@PathVariable List<Long> ids) {
        ResponseDTO responseDTO = buildingService.deleteBuildings(ids);
        return responseDTO;
    }
}
