package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
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
        for(TransactionEntity transaction : transactionEntities){
            transactionDTOS.add(transactionConverter.toTransactionDTO(transaction));
        }
        return transactionDTOS;
    }

    @Override
    public ResponseDTO createOrUpdate(TransactionDTO transactionDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        TransactionEntity transactionEntity = transactionConverter.toTransactionEntity(transactionDTO);

        if(transactionDTO.getId() == null){
            responseDTO.setMessage("Thêm giao dịch thành công");
        }
        else responseDTO.setMessage("Cập nhật giao dịch thành công");

        transactionRepository.save(transactionEntity);

        return responseDTO;
    }

    @Override
    public ResponseDTO loadTransaction(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        TransactionEntity transactionEntity = transactionRepository.findById(id).get();
        responseDTO.setMessage("Tải thông tin giao dịch thành công");
        responseDTO.setData(transactionEntity.getNote());
        return responseDTO;
    }
}
