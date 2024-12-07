package com.javaweb.repository.custom.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> findAll(CustomerSearchRequest params, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT c.* FROM customer c ");

        handleJoinTable(params, sql);
        handleWhereCondition(params, sql);

        sql.append(" GROUP BY c.id");	//handle duplicate
        sql.append(" LIMIT ").append(pageable.getPageSize()).append(" OFFSET ").append(pageable.getOffset());

        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    public void handleJoinTable(CustomerSearchRequest params, StringBuilder sql) {
        /* join to get staffid */
        Long staffId = params.getStaffId();
        if (staffId != null) {
            sql.append(" JOIN assignmentcustomer ass ON c.id = ass.customerid ");
        }
    }

    public void handleWhereCondition(CustomerSearchRequest params, StringBuilder sql) {
        sql.append(" WHERE 1 = 1 AND c.is_active = 1 ");       // chi lay nhung customer active

        try {
            Field[] fields = CustomerSearchRequest.class.getDeclaredFields();	// ham nay get ra nhu
            for (Field fi : fields) {
                fi.setAccessible(true);
                String key = fi.getName();
                Object value = fi.get(params);
                if (value != null && value.toString().trim() != "") {
                    if(key.equals("staffId")){
                        sql.append(" AND ass.staffid = " + value);
                    } else if (key.equals("createdBy")) {
                        sql.append(" AND c.createdby LIKE '%" + value + "%' ");
                    } else{
                        sql.append(" AND c." + key + " LIKE '%" + value + "%' ");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int countTotalItems(CustomerSearchRequest params) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM customer c");

        handleJoinTable(params, sql);
        handleWhereCondition(params, sql);

        Query query = entityManager.createNativeQuery(sql.toString());
        Object result = query.getSingleResult();
        return ((Number) result).intValue();
    }
}
