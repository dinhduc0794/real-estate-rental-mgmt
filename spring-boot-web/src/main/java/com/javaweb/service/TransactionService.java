package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> findAllByCodeAndCustomer(String code, Long id);
    ResponseDTO createOrUpdate(TransactionDTO transactionDTO);
    ResponseDTO loadTransaction(Long id);
}
