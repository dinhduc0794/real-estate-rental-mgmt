package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>{
	void deleteAllByBuilding(BuildingEntity buildingEntity);
	void deleteAllByBuildingIn(List<BuildingEntity> buildingEntities);
}
