package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.utils.ConnectionUtil;
import java.sql.Connection;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public DistrictEntity findDistrictById(Long districtId) {
		StringBuilder sql = new StringBuilder("SELECT id, code, name FROM district WHERE id = " + districtId);
		DistrictEntity district = null;
		try (Connection conn = ConnectionUtil.GetConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString());){
			while(rs.next()) {
				district = new DistrictEntity();
				
				district.setId(rs.getLong("id"));
				district.setCode(rs.getString("code"));
				district.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connected database failed...");
			return null;
		}
		
		return district;
	}

	
	//	@Override
//	public List<DistrictEntity> findAll(Long districtId) {
//		// TODO Auto-generated method stub
//		StringBuilder sql = new StringBuilder("SELECT d.* FROM district d WHERE 1=1");
//		
//		if (districtId != null ) {
//			sql.append(" AND b.id =" + districtId);
//		}
//		
//		List<DistrictEntity> districtEntities = new ArrayList<DistrictEntity>();
//		try (Connection conn = ConnectionUtil.GetConnection();
//				Statement stm = conn.createStatement();	
//				ResultSet rs = stm.executeQuery(sql.toString());) {
//			while(rs.next()) {
//				DistrictEntity district = new DistrictEntity();
//				
//				district.setId(rs.getLong("id"));
//				district.setCode(rs.getString("code"));
//				district.setName(rs.getString("name"));
//				
//				districtEntities.add(district);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connected database failed...");
//			return null;
//		}
//		return districtEntities;
//	}


}
