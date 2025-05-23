package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.exception.DataNotFoundException;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
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
    public ResponseDTO createOrUpdate(CustomerDTO customerDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        CustomerEntity customerEntity = customerConverter.toCustomerEntity(customerDTO);

        if (customerEntity.getId() != null) {
            // khi cap nhat khach hang, phai giu lai danh sach nhan vien cu
            CustomerEntity oldCustomer = customerRepository.findById(customerEntity.getId()).get();
            customerEntity.setStaffList(oldCustomer.getStaffList());
            responseDTO.setMessage("Cập nhật khách hàng thành công");
        } else {
            responseDTO.setMessage("Thêm khách hàng thành công");
        }

        customerRepository.save(customerEntity);
        return responseDTO;
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
    public CustomerDTO findByIdAndIsActive(Long id, Integer isActive) {
        CustomerEntity customerEntity = customerRepository.findByIdAndIsActive(id, isActive);
        return customerEntity != null ? customerConverter.toCustomerDTO(customerEntity) : null;
    }

    @Override
    public ResponseDTO updateAssignmentModal(AssignmentCustomerDTO assignmentCustomerDTO) {
        Long customerId = assignmentCustomerDTO.getCustomerId();
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();

        List<UserEntity> assignedStaffs = userRepository.findByIdIn(assignmentCustomerDTO.getStaffIds());

        customerEntity.setStaffList(assignedStaffs);
        customerRepository.save(customerEntity);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Giao khách hàng cho nhân viên thành công");
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteCustomerByIds(List<Long> ids) { //throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        List<CustomerEntity> customerEntities = customerRepository.findAllById(ids);

        if (customerEntities != null && customerEntities.size() > 0) {
            for (CustomerEntity customerEntity : customerEntities) {
                customerEntity.setIsActive(0);
            }
            customerRepository.saveAll(customerEntities);
            responseDTO.setMessage("Xóa khách hàng thành công");
        }
        else {
            responseDTO.setMessage("Không tìm thấy khách hàng nào để xóa");
            //throw new DataNotFoundException("Not found any customer by ids");
        }
        return responseDTO;
    }
}
