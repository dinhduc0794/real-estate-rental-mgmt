package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	void delete(Long[] id);
	List<BuildingEntity> findAll(String name, String ward);
}
