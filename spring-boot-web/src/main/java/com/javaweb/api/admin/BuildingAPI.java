package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/buildings"))
public class BuildingAPI {
    @PostMapping
    private Object createOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        //xuong service -> xuong repo -> save vao db
        return null;
    }
}
