package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TransactionRepoistory;
import com.example.dao.UserRepository;
import com.example.entity.Transaction;
import com.example.entity.User;



@Service
public class UserServiceImpl {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepoistory transactionRepoistory;

    public int getTotleReward(String username){
        
        User user = userRepository.findByName(username);
       
        List<Transaction> transactions = transactionRepoistory.findByUserId(user.getId());

        return getReward(transactions);
    }

    public int getMonthReward(String username, int month){
        User user = userRepository.findByName(username);

        List<Transaction> transactions = transactionRepoistory.findByUserIdAndMonth(user.getId(), month);
        
        return getReward(transactions);

    }

    public int getReward(List<Transaction> transactions){
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
