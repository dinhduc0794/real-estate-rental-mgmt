package com.javaweb.controller.admin;



import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService;
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/admin/building-list")
    private ModelAndView buildingList(@ModelAttribute(name = "modelSearch") BuildingSearchRequest buildingSearchRequest,
                                      @RequestParam Map<String, Object> params,
                                      @RequestParam(name="typeCode", required = false) List<String> typeCodes){
        //Xuong DB de lay data...
        List<BuildingSearchResponse> responses = buildingService.findAll(params, typeCodes);

        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("buildingList", responses);

//        mav.addObject("modelSearch", buildingSearchRequest);
        mav.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        mav.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        mav.addObject("staffList", userService.mapStaff_IdAndUsername());
        mav.addObject("typeCodes", BuildingType.type());

        return mav;
    }

    @GetMapping("/admin/building-edit")
    private ModelAndView buildingEdit(@ModelAttribute(name="buildingEdit") BuildingDTO buildingDTO){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        modelAndView.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        return modelAndView;
    }

    @GetMapping("/admin/building-edit-{id}")
    private ModelAndView buildingEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        modelAndView.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"

        //xuong db dung ham findById de lay data toa nha hien tai => BuildingEntity -> Convert qua BuildingDTO
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(3L);
        buildingDTO.setName("BDF Tower");
        buildingDTO.setRentArea("200,350,450");
        buildingDTO.setWard("Phường 2");
        buildingDTO.setDistrict("QUAN_2");
        List<String> typeCodes = new ArrayList<>();     //khi lay ra typeCode se la String -> can tach chuoi ra dua ve List
        typeCodes.add("TANG_TRET");
        typeCodes.add("NGUYEN_CAN");
        buildingDTO.setTypeCodes(typeCodes);
        buildingDTO.setNumberOfBasement(1L);
        buildingDTO.setManagerName("Sieu Nhan Do");
        modelAndView.addObject("buildingEdit", buildingDTO);
        return modelAndView;
    }
}
