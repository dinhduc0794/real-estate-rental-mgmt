package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionConverter transactionConverter;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<TransactionDTO> findAllByCodeAndCustomer(String code, Long id) {
        CustomerEntity customer = customerRepository.findById(id).get();
        List<TransactionEntity> transactionEntities = transactionRepository.findAllByCodeAndCustomer(code, customer);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for(TransactionEntity t : transactionEntities){
            transactionDTOS.add(transactionConverter.toTransactionDTO(t));
        }
        return transactionDTOS;
    }
}
