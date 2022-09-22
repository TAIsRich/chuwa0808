package com.chuwa.project.service;

import com.chuwa.project.payload.RewardDto;
import com.chuwa.project.payload.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(Long cid, TransactionDto transactionDto);
    TransactionDto getALLTransactionsByTransId(Long id);
    List<TransactionDto> getTransactionByCustomerId(Long cid);
    TransactionDto upateTransaction(Long trans_id, TransactionDto transactionDto);
    void deleteTransaction(Long id);



}
