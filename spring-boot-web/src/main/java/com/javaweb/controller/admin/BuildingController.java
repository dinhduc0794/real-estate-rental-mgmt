package com.javaweb.controller.admin;



import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.BuildingService;
import com.javaweb.service.UserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private UserService userService;
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/admin/building-list")
    private ModelAndView buildingList(@ModelAttribute(name = "modelSearch") BuildingSearchRequest params,
                                      HttpServletRequest request){

        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        mav.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        mav.addObject("staffList", userService.mapStaff_IdAndUsername());

        //Xuong DB de lay data...
        BuildingSearchResponse model = new BuildingSearchResponse();
        DisplayTagUtils.of(request, model);

        // Neu la staff thi chi xem duoc toa nha cua minh quan ly
        if (SecurityUtils.getAuthorities().contains(SystemConstant.STAFF_ROLE)) {
            params.setStaffId(SecurityUtils.getPrincipal().getId());
        }

        List<BuildingSearchResponse> responses = buildingService.findAll(params, PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
        model.setListResult(responses);
        model.setTotalItems(buildingService.countTotalItems(params));

        mav.addObject(SystemConstant.MODEL, model);

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

        // Neu la staff thi chi xem duoc toa nha cua minh quan ly
        if (SecurityUtils.getAuthorities().contains(SystemConstant.STAFF_ROLE)) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            if (buildingService.isStaffOfBuilding(staffId, id) == false) {
                mav.setViewName("redirect:/error/404");
                return mav;
            }
        }

        //xuong db dung ham findById de lay data toa nha hien tai => BuildingEntity -> Convert qua BuildingDTO
        BuildingDTO buildingDTO = buildingService.findById(id);

        mav.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        mav.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        mav.addObject("buildingEdit", buildingDTO);
        return mav;
    }
}
