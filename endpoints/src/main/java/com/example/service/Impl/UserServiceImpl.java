package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TransactionRepoistory;
import com.example.dao.UserRepository;
import com.example.dto.ResponseResult;
import com.example.entity.Transaction;
import com.example.entity.User;
import com.example.enums.AppHttpCodeEnum;



@Service
public class UserServiceImpl {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepoistory transactionRepoistory;

    public ResponseResult getTotleReward(String username){
        
        User user = userRepository.findByName(username);
        
        if(user == null) return ResponseResult.errorResult(AppHttpCodeEnum.NO_USER);
        
        List<Transaction> transactions = transactionRepoistory.findByUserId(user.getId());

        if(transactions.size() == 0) return ResponseResult.errorResult(AppHttpCodeEnum.NO_TRANSACTION);
        
        int reward = getReward(transactions);
        return ResponseResult.okResult(reward);
    }

    public ResponseResult getMonthReward(String username, int month){

        User user = userRepository.findByName(username);

        if(user == null) return ResponseResult.errorResult(AppHttpCodeEnum.NO_USER);
       
        List<Transaction> transactions = transactionRepoistory.findByUserIdAndMonth(user.getId(), month);
       
        if(transactions.size() == 0) return ResponseResult.errorResult(AppHttpCodeEnum.NO_TRANSACTION);

        int reward = getReward(transactions);
        return ResponseResult.okResult(reward);

    }

    private int getReward(List<Transaction> transactions){
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
