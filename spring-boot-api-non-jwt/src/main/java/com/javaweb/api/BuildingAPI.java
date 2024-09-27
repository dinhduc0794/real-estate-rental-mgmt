package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@RestController
@PropertySource("classpath:application.properties")
@Transactional
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@GetMapping(value = "/api/buildings")
	public Object getBuilding(@RequestParam Map<String, Object> params,
								@RequestParam(name = "typeCode", required = false) List<String> typeCodes) {
		List<BuildingResponseDTO> buildingResponseDTOs = buildingService.findAll(params, typeCodes);
		return buildingResponseDTOs; 
	}
	
	public void validate(BuildingDTO building) {
		if (building.getName() == null 
				|| building.getName().equals("") 
				|| building.getNumberOfBasement() == null) {
			throw new FieldRequiredException("Name & NumberOfBasement are NOT NULL key");
		}
	}
	
	@PostMapping(value = "/api/buildings")
	public void createBuilding(@RequestBody BuildingDTO buildingDTO) {
		validate(buildingDTO);
		buildingService.createBuilding(buildingDTO);
	}
	
	@DeleteMapping(value = "/api/buildings/{id}")
	public void deleteBuilding(@PathVariable(name = "id") Long[] buildingId) {
		buildingService.deleteBuilding(buildingId);
	}
}
 
