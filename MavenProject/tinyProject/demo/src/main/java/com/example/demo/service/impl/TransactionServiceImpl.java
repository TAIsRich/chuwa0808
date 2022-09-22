package com.example.demo.service.impl;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.security.User;
import com.example.demo.payload.ReturnTransactionDto;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public ReturnTransactionDto getTransactionFor3Month(long user_id) {
        List<Transaction> trans = transactionRepository.findByUserId(user_id);
        Map<Integer,List<Transaction>> hm = trans.stream().collect(
                Collectors.groupingBy(
                        Transaction::getMonth
                )
        );
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new NullPointerException("not found user id: " + user_id)
        );
        HashMap<Integer,Double> hashmap = new HashMap<>();
        int total = 0;
        for(int key : hm.keySet()){
            List<Transaction> temp = hm.get(key);
            double avg = temp.stream().mapToDouble(
                    t->{
                        double p = t.getPrice();
                        double award = 0.0;
                        if(p > 100){
                            award += (p-100)*2+50;
                        }
                        if(p > 50 && p <= 100){
                            award += p-50;
                        }
                        return award;
                    }
            ).sum();
            total += avg;
            avg = avg/ temp.size();
            hashmap.put(key,avg);
        }
        ReturnTransactionDto returnTransactionDto = new ReturnTransactionDto(user,total,hashmap);

        return returnTransactionDto;
    }
}
