package com.javaweb.controller.admin;



import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService;

    @GetMapping("/admin/building-list")
    private ModelAndView buildingList(@ModelAttribute(name = "modelSearch") BuildingSearchRequest params){
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        modelAndView.addObject("district", DistrictCode.type());    //"QUAN_1" "Quận 1"
        modelAndView.addObject("rentType", BuildingType.type());    //"NGUYEN_CAN" "Nguyên căn"
        modelAndView.addObject("staffList", userService.mapStaff_IdAndUsername());

        //Xuong DB de lay data...
        List<BuildingSearchResponse> responses = new ArrayList<>();
        BuildingSearchResponse building1 = new BuildingSearchResponse();
        building1.setId(1L);
        building1.setName("ACM Tower");
        building1.setRentArea("100,200,300");
        building1.setAddress("14 Phan Xích Long, phường 6, Quận 2");
        building1.setNumberOfBasement(2L);
        building1.setManagerName("Chu Be Loat Choat");
        responses.add(building1);

        BuildingSearchResponse building2 = new BuildingSearchResponse();
        building2.setId(3L);
        building2.setName("BDF Tower");
        building2.setRentArea("200,350,450");
        building2.setAddress("268 Lý Thường Kiệt, phường 2, Quận 10");
        building2.setNumberOfBasement(1L);
        building2.setManagerName("Sieu Nhan Do");
        responses.add(building2);

        modelAndView.addObject("buildingList", responses);

        return modelAndView;
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
