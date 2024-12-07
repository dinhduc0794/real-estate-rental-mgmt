package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public TransactionDTO toTransactionDTO(TransactionEntity transactionEntity){
        TransactionDTO transactionDTO = modelMapper.map(transactionEntity, TransactionDTO.class);
        // Custom mapping
        transactionDTO.setCustomerId(transactionEntity.getCustomer().getId());
        return transactionDTO;
    }

    public TransactionEntity toTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity transactionEntity = modelMapper.map(transactionDTO, TransactionEntity.class);

        // Custom mapping
        CustomerEntity customerEntity = customerRepository.findById(transactionDTO.getCustomerId()).get();
        UserEntity userEntity = userRepository.findById(transactionDTO.getStaffId()).get();
        if(transactionDTO.getId() != null){
            TransactionEntity ent = transactionRepository.findById(transactionDTO.getId()).get();
            transactionEntity.setCreatedDate(ent.getCreatedDate());
            transactionEntity.setCreatedBy(ent.getCreatedBy());
            transactionEntity.setModifiedDate(new Date());
            transactionEntity.setModifiedBy(userEntity.getUserName());
        }
        else{
            transactionEntity.setCreatedBy(userEntity.getUserName());
        }
        transactionEntity.setCustomer(customerEntity);
        return transactionEntity;
    }
}
