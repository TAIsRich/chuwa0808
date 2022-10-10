package com.example.reward_system.service;

import com.example.reward_system.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(long customer_id, TransactionDto transactionDto);
    List<TransactionDto> getAllTransaction();
    List<TransactionDto> getAllTransactionByCustomerId(long customer_id);
    TransactionDto getTransactionById(long id);
    TransactionDto updateTransaction(TransactionDto transactionDto, long id);
    void deleteTransaction(long id);
}
