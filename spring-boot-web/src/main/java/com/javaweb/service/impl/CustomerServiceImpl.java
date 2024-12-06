package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> findAll(CustomerSearchRequest params, Pageable pageable) {
        List<CustomerEntity> customerEntities = customerRepository.findAll(params, pageable);
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (CustomerEntity ent : customerEntities) {
            customerDTOs.add(customerConverter.toCustomerDTO(ent));
        }
        return customerDTOs;
    }

    @Override
    public int countTotalItems(CustomerSearchRequest params) {
        return customerRepository.countTotalItems(params);
    }

    @Override
    public boolean isStaffOfCustomer(Long staffId, Long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        UserEntity staff = userRepository.findById(staffId).get();
        if (customerEntity.getStaffList().contains(staff)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CustomerDTO findByIdAndIsActive(Long id, Boolean isActive) {
        CustomerEntity customerEntity = customerRepository.findByIdAndIsActive(id, isActive);
        return customerEntity != null ? customerConverter.toCustomerDTO(customerEntity) : null;
    }
}
