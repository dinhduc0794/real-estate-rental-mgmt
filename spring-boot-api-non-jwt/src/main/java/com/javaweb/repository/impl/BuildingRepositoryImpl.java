package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	public void handleJoinTable(Map<String, Object> params, StringBuilder sql) {
		/* join to get typecode */
        // neu params co typecode -> join renttype de lay typecode
		String typeCode = (String) params.get("typeCode");
        if (StringUtil.notEmptyData(typeCode)) {
            sql.append(" JOIN buildingrenttype brt ON b.id = brt.buildingid")
               .append(" JOIN renttype rt ON brt.renttypeid = rt.id");
        }
        
        /* join to get staffid */ 
        String staffId = (String) params.get("staffId");
        if (StringUtil.notEmptyData(staffId)) {
        	sql.append(" JOIN assignmentbuilding ab ON b.id = ab.buildingid");
        }
        
     
        /* join to get rentareavalue */
        String rentAreaFrom = (String) params.get("rentAreaFrom");
        String rentAreaTo = (String) params.get("rentAreaTo");
        if (StringUtil.notEmptyData(rentAreaFrom) || StringUtil.notEmptyData(rentAreaTo)) {
        	sql.append(" JOIN rentarea ra ON b.id = ra.buildingid");
        }
	}
	
	public void handleWhereCondition(Map<String, Object> params, List<String> typeCodes, StringBuilder sql) {
		sql.append(" WHERE 1=1");
        
        // handle typeCodes
		if (typeCodes != null && !typeCodes.isEmpty()) {
			String tC = typeCodes.stream().map(i -> "'" + i + "'").collect(Collectors.joining(", "));
			sql.append(" AND rt.code IN (" + tC + ")");	
		}

        // if (typeCodes != null && !typeCodes.isEmpty()) {
        // 	String tC = "";
        //     for (int i = 0; i < typeCodes.size(); i++) {
        //     	if (typeCodes.get(i) != null) {
        //     		tC += "'" + typeCodes.get(i) + "'";
        //     	}
        //     	if (i != typeCodes.size() - 1) {
        //             tC += ", ";
        //         }
        //     }
        //     sql.append(" AND rt.code IN (" + tC + ")");	
        // }

        // duyet map handle cac attribute con lai, tru typecode
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if (value != null && !value.toString().equals("")) {
            	switch (key) {
	                case "typeCode":
	                	break;
	                case "rentAreaFrom":
	                	sql.append(" AND ra.value >= " + value);
	                	break;
	                case "rentAreaTo":
	                	sql.append(" AND ra.value <= " + value);
	                	break;
	                case "rentPriceFrom":
	                	sql.append(" AND b.rentPrice >= " + value);
	                	break;
	                case "rentPriceTo":
	                	sql.append(" AND b.rentPrice <= " + value);
	                    break;
	                case "staffId":
	                	sql.append(" AND ab.staffid = " + value);
	                	break;
	                default:	                  
	                	if (value instanceof Number) {
	                		sql.append(" AND b." + key + " = " + value);
	                    }
	                	else if (value instanceof String){
	                    	sql.append(" AND b." + key + " LIKE '%" + value.toString() + "%'");
	                    }
	                	break;
                }	
            }
        }
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCodes) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		 
		handleJoinTable(params, sql);
		handleWhereCondition(params, typeCodes, sql);
		
		sql.append(" GROUP BY b.id");	//handle duplicate
		
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
		        building.setStructure(rs.getString("structure"));
		        building.setNumberOfBasement(rs.getLong("numberOfBasement"));
		        building.setFloorArea(rs.getLong("floorArea"));
		        building.setDirection(rs.getString("direction"));
		        building.setLevel(rs.getString("level"));
		        building.setRentPrice(rs.getLong("rentPrice"));
		        building.setRentPriceDesc(rs.getString("rentPriceDescription"));
		        building.setServiceFee(rs.getString("serviceFee"));
		        building.setCarFee(rs.getString("carFee"));
		        building.setMotorbikeFee(rs.getString("motorbikeFee"));
		        building.setOvertimeFee(rs.getString("overtimeFee"));
		        building.setWaterFee(rs.getString("waterFee"));
		        building.setElectricityFee(rs.getString("electricityFee"));
		        building.setDeposit(rs.getString("deposit"));
		        building.setPayment(rs.getString("payment"));
		        building.setRentTime(rs.getString("rentTime"));
		        building.setDecorationTime(rs.getString("decorationTime"));
		        building.setBrokerageFee(rs.getDouble("brokerageFee"));
		        building.setNote(rs.getString("note"));
		        building.setLinkOfBuilding(rs.getString("linkOfBuilding"));
		        building.setMap(rs.getString("map"));
		        building.setImage(rs.getString("image"));
		        building.setCreatedDate(rs.getString("createdDate"));
		        building.setModifiedDate(rs.getString("modifiedDate"));
		        building.setCreatedBy(rs.getString("createdBy"));
		        building.setModifiedBy(rs.getString("modifiedBy"));
		        building.setManagerName(rs.getString("managerName"));
		        building.setManagerPhone(rs.getString("managerPhoneNumber"));
		        
				buildingEntities.add(building);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed...");
			return null;
		}
		return buildingEntities;
	}
}
