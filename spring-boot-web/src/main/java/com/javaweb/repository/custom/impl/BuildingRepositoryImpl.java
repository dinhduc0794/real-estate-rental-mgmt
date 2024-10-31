package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");

        handleJoinTable(buildingSearchBuilder, sql);
        handleWhereCondition(buildingSearchBuilder, sql);

        sql.append(" GROUP BY b.id");	//handle duplicate

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    public void handleJoinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        /* join to get staffid */
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            sql.append(" JOIN assignmentbuilding ab ON b.id = ab.buildingid");
            sql.append(" JOIN user u ON ab.staffid = u.id ");
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

        // thay đổi code vì typecode bây giờ là enum trong bảng building chứ không phải một bảng khác riêng
        List<String> typeCodes = buildingSearchBuilder.getTypeCode();
        if (typeCodes != null && !typeCodes.isEmpty()) {
            sql.append(" AND (");
            String tmp = typeCodes.stream().map(it-> "b.type LIKE " + "'%" + it + "%'").collect(Collectors.joining(" OR "));
            sql.append(tmp + " ) ");
        }

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
}
