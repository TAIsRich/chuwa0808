package com.example.rewardpoints.repository;

import com.example.rewardpoints.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
