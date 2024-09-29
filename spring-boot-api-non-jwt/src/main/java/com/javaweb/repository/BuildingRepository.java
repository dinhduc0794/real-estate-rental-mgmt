package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
	List<BuildingEntity> findByNameContainingAndWardContaining(String name, String ward);
	List<BuildingEntity> findByNameContainingAndDistrict_NameContaining(String name, String districtName);
	
	List<BuildingEntity> findByIdIn(Long[] ids);
	void deleteByIdIn(Long[] ids); 
}
 