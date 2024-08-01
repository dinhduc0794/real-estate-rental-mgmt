package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionUtil;



@Repository
public class BuildingRepositoryImpl implements BuildingRepository{

	@Override
	public List<BuildingEntity> findAll(String name, String ward) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b WHERE 1=1");
		
		if (name != null && !name.equals("")) {
			sql.append(" AND b.name LIKE '%" + name + "%'");
		}
		
		if (ward != null && !ward.equals("")) {
			sql.append(" AND b.name LIKE '%" + ward + "%'");
		}
		
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();
		try (Connection conn = ConnectionUtil.GetConnection();
				Statement stm = conn.createStatement();	
				ResultSet rs = stm.executeQuery(sql.toString());) {
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setDistrictId(rs.getLong("districtId"));
				buildingEntities.add(building);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed...");
			return null;
		}
		return buildingEntities;
	}
	@Override
	public void delete(Long[] id) {
		// TODO Auto-generated method stub
		
	}
}
