package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionUtil;



@Repository
public class BuildingRepositoryImpl implements BuildingRepository{

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCodes) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		
		// check client co request typecode ko
        boolean hasTypeCodes = typeCodes != null && !typeCodes.isEmpty();
        	
        // neu co thi join renttype de lay typecode
        if (hasTypeCodes) {
            sql.append(" INNER JOIN buildingrenttype brt ON b.id = brt.buildingid")
               .append(" INNER JOIN renttype rt ON brt.renttypeid = rt.id");
        }
        
        sql.append(" WHERE 1=1");
        
        // handle typeCodes
        if (hasTypeCodes) {
        	sql.append(" AND rt.code IN (");	
            for (int i = 0; i < typeCodes.size(); i++) {
            	String typeCode = typeCodes.get(i);
            	sql.append("'" + typeCode + "'");
            	if (i != typeCodes.size() - 1) {
                    sql.append(", ");
                }
            }
            sql.append(")");	
        }
        
     // Handle area and rent price range
        if (params.containsKey("floorAreaFrom")) {
            sql.append(" AND b.floorArea >= ").append(params.get("floorAreaFrom"));
        }
        if (params.containsKey("floorAreaTo")) {
            sql.append(" AND b.floorArea <= ").append(params.get("floorAreaTo"));
        }
        if (params.containsKey("rentPriceFrom")) {
            sql.append(" AND b.rentPrice >= ").append(params.get("rentPriceFrom"));
        }
        if (params.containsKey("rentPriceTo")) {
            sql.append(" AND b.rentPrice <= ").append(params.get("rentPriceTo"));
        }

        // duyet map handle cac attribute con lai, tru typecode
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if (value != null && !value.toString().equals("")) {
            	switch (key) {
	                case "typeCode":
	                case "floorAreaFrom":
	                case "floorAreaTo":
	                case "rentPriceFrom":
	                case "rentPriceTo":
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
