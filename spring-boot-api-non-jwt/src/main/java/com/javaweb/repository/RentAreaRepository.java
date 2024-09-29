package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>{
	void deleteAllByBuildingEntity(BuildingEntity buildingEntity);
	void deleteAllByBuildingEntityIn(List<BuildingEntity> buildingEntities);
}
