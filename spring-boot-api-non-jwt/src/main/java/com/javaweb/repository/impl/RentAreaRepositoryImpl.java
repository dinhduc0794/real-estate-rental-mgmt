package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.ConnectionUtil;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{

	@Override
	public List<RentAreaEntity> findByBuildingId(Long buildingId) {
		StringBuilder sql = new StringBuilder("SELECT ra.* FROM rentarea ra WHERE buildingId = " + buildingId);
		
		List<RentAreaEntity> rentAreaEntities = new ArrayList<RentAreaEntity>();
		try (Connection conn = ConnectionUtil.GetConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString());){
			while(rs.next()) {
				RentAreaEntity rentArea = new RentAreaEntity();
				
				rentArea.setId(rs.getLong("id"));
				rentArea.setValue(rs.getLong("value"));
				rentArea.setBuildingId(rs.getLong("buildingId"));
				rentArea.setCreatedDate(rs.getString("createdDate"));
				rentArea.setModifiedDate(rs.getString("modifiedDate"));
				rentArea.setCreatedBy(rs.getString("createdBy"));
				rentArea.setModifiedBy(rs.getString("modifiedBy"));
				
				rentAreaEntities.add(rentArea);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connected database failed...");
			return null;
		}
		
		return rentAreaEntities;
	}

}
