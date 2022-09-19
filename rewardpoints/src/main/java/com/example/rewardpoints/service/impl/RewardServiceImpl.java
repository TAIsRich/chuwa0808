package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.entity.Transaction;
import com.example.rewardpoints.repository.TransactionRepository;
import com.example.rewardpoints.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    private static final BigDecimal VALUE_50 = BigDecimal.valueOf(50);
    private static final BigDecimal VALUE_100 = BigDecimal.valueOf(100);
    private static final BigDecimal MULTIPLIER_50 = BigDecimal.valueOf(1);
    private static final BigDecimal MULTIPLIER_100 = BigDecimal.valueOf(2);

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public BigDecimal getPoints() {
        return getPoints((List<Transaction>) transactionRepository.findAll());
    }

    public BigDecimal getPoints(List<Transaction> transactions) {

        if (transactions.size() == 0) {
            throw new RuntimeException();
        }

        BigDecimal sum = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            sum = sum.add(getPoints(transaction));
        }

        return sum;
    }

    private BigDecimal getPoints(Transaction transaction) {

        if (transaction.getCost().compareTo(VALUE_50) <= 0) {
            return BigDecimal.ZERO;
        } else if (transaction.getCost().compareTo(VALUE_100) <= 0) {
            return transaction.getCost().subtract(VALUE_50).multiply(MULTIPLIER_50);
        } else {
            return transaction.getCost().subtract(VALUE_100).multiply(MULTIPLIER_100)
                    .add(VALUE_50.multiply(MULTIPLIER_50));
        }

    }
}
