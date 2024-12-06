package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> findAllByCodeAndCustomer(String code, Long id);
}
