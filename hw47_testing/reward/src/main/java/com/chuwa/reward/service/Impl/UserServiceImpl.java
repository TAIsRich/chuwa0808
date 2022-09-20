package com.chuwa.reward.service.Impl;

import com.chuwa.reward.dao.TransactionRepository;
import com.chuwa.reward.dao.UserRepository;
import com.chuwa.reward.entity.Transaction;
import com.chuwa.reward.entity.User;
import com.chuwa.reward.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepoistory;

    @Override
    public int getReward(String username) {
        User user = userRepository.findByUsername(username);

        List<Transaction> transactions = transactionRepoistory.findByUserId(user.getId());

        return calReward(transactions);
    }

    @Override
    public int getMonthReward(String username, int month) {
        User user = userRepository.findByUsername(username);

        List<Transaction> transactions = transactionRepoistory.findByUserIdAndMonth(user.getId(), month);

        return calReward(transactions);
    }

    private int calReward(List<Transaction> transactions){
        int total = 0;

        for(Transaction t : transactions){
            Double price = t.getPrice();
            if(price >= 50 && price < 100){
                total += (price - 50);
            }if(price >= 100.00){
                total += (2*(price - 100) + 50);
            }
        }

        return total;
    }
}
