package com.example.demo.service;

import com.example.demo.payload.ReturnTransactionDto;

public interface TransactionService {
    ReturnTransactionDto getTransactionFor3Month(long user_id);
}
