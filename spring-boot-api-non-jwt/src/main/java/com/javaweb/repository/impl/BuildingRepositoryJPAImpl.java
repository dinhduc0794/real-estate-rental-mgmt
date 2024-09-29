package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionUtil;
import com.javaweb.utils.StringUtil;

@Repository
@Primary
public class BuildingRepositoryJPAImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void handleJoinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		/* join to get typecode */
        // neu params co typecode -> join renttype de lay typecode
		List<String> typeCodes = buildingSearchBuilder.getTypeCode();
        if (typeCodes != null && !typeCodes.isEmpty()) {
            sql.append(" JOIN buildingrenttype brt ON b.id = brt.buildingid")
               .append(" JOIN renttype rt ON brt.renttypeid = rt.id");
        }
        
        /* join to get staffid */ 
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
        	sql.append(" JOIN assignmentbuilding ab ON b.id = ab.buildingid");
        }
        
     
        /* join to get rentareavalue */
        Long rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
        Long rentAreaTo = buildingSearchBuilder.getRentAreaTo();
        if (rentAreaFrom != null || rentAreaTo != null) {
        	sql.append(" JOIN rentarea ra ON b.id = ra.buildingid");
        }
	}
	
	public void handleWhereCondition(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		sql.append(" WHERE 1=1");
        
        // handle typeCodes
		List<String> typeCodes = buildingSearchBuilder.getTypeCode();
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
		// update: duyet object bang java reflection	
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();	// ham nay get ra nhu 
			for (Field fi : fields) {
				fi.setAccessible(true);
				String key = fi.getName();
				Object value = fi.get(buildingSearchBuilder);
				if (value != null) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
		//  for (Map.Entry<String, Object> entry : params.entrySet()) {
		//  String key = entry.getKey();
		//  Object value = entry.getValue();
		//  if (value != null && !value.toString().equals("")) {
		//  }
		//}

//	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		 
		handleJoinTable(buildingSearchBuilder, sql);
		handleWhereCondition(buildingSearchBuilder, sql);
		
		sql.append(" GROUP BY b.id");	//handle duplicate
		
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
	}

//	@Override
	public void delete(Long[] id) {
		// TODO Auto-generated method stub
		
	}
}
