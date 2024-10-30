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
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("buildingEdit", buildingDTO);
        mav.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        mav.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        return mav;
    }

    @GetMapping("/admin/building-edit-{id}")
    private ModelAndView buildingEdit(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        //xuong db dung ham findById de lay data toa nha hien tai => BuildingEntity -> Convert qua BuildingDTO
        BuildingDTO buildingDTO = buildingService.findById(id);

        mav.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        mav.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        mav.addObject("buildingEdit", buildingDTO);
        return mav;
    }
}
