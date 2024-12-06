package com.javaweb.service;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll(CustomerSearchRequest params, Pageable pageable);
    int countTotalItems(CustomerSearchRequest params);
    ResponseDTO createOrUpdate(CustomerDTO customerDTO);
    boolean isStaffOfCustomer(Long staffId, Long customerId);
    CustomerDTO findByIdAndIsActive(Long id, Long isActive);
    ResponseDTO turnOffIsActive(List<Long> ids);
    ResponseDTO updateAssignmentModal(AssignmentCustomerDTO assignmentCustomerDTO);
}
