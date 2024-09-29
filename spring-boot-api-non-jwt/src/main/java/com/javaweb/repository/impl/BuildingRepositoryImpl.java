package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository	
public class BuildingRepositoryImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	
//	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		// JPQL
//		String jpql = "FROM BuildingEntity b WHERE 1=1 AND b.name LIKE '%building%'";
//		Query query = entityManager.createQuery(jpql, BuildingEntity.class);	//tham số là câu query và class để ánh xạ dữ liệu qua
		
		String sql = "SELECT * FROM building b WHERE 1=1 AND b.name LIKE '%building%'";
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
	}

//	@Override
	public void delete(Long[] id) {
		// TODO Auto-generated method stub
		
	}
	
}
