package com.task.rewardpoints.service;

import com.task.rewardpoints.dao.TransactionRepository;
import com.task.rewardpoints.dto.Reward;
import com.task.rewardpoints.dto.RewardResponse;
import com.task.rewardpoints.entity.Transaction;
import com.task.rewardpoints.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private static final int REWARD_THRESHOLD_50 = 50;
    private static final int REWARD_THRESHOLD_100 = 100;
    private static final int REWARD_POINTS_2 = 2;

    @Autowired
    private TransactionRepository transactionRepository;

    public RewardResponse getRewards(long customerId) {
        final RewardResponse rewardResponse = new RewardResponse();
        final List<Transaction> transactions = transactionRepository.findAllTransactionsByCustomerId(customerId);

        if (transactions.isEmpty()) {
            throw new CustomerNotFoundException(customerId);
        }
        rewardResponse.customerId = customerId;
        final Map<Month, List<Transaction>> map = transactions.stream().collect(Collectors.groupingBy(transaction -> Month.of(transaction.getDate().getMonth() + 1)));

        map.entrySet().forEach(objectListEntry -> {
            Reward reward = new Reward();
            reward.month = objectListEntry.getKey();
            reward.reward =
                    objectListEntry.getValue()
                            .stream()
                            .filter(transaction -> transaction.getAmount() > REWARD_THRESHOLD_50)
                            .mapToDouble(
                                    transaction -> {
                                        double amount = transaction.getAmount();
                                        double reward1 = amount > REWARD_THRESHOLD_100 ? REWARD_THRESHOLD_50 : amount - REWARD_THRESHOLD_50;
                                        double reward2 = amount > REWARD_THRESHOLD_100 ? (amount - REWARD_THRESHOLD_100) * REWARD_POINTS_2 : 0;
                                        return reward1 + reward2;
                                    }).sum();
            rewardResponse.total += reward.reward;
            rewardResponse.rewards.add(reward);
        });

        return rewardResponse;
    }
}
