package com.example.rewardpoints.service;

import com.example.rewardpoints.dto.TransactionDto;

import java.util.List;


public interface TransactionService {

    TransactionDto createTransaction(Long customerId, TransactionDto transactionDto);

    List<TransactionDto> getTransactionsByName(String name);

    Double getRewardByMonth(String name, String time);

    Double getRewardTotal(String name);

    Double calculateReward(Double money);
}
