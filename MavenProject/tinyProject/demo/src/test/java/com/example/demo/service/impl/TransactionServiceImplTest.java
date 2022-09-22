package com.example.demo.service.impl;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.security.User;
import com.example.demo.payload.ReturnTransactionDto;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
    @Mock
    TransactionRepository transactionRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    TransactionServiceImpl transactionService;

    List<Transaction> trans = new ArrayList<>();
    User u = new User();
    HashMap<Integer,Double> hm = new HashMap<>();

    @BeforeEach
    void setup(){

        u.setId(1);
        u.setName("user");
        u.setPassword("user");

        Transaction t1 = new Transaction(1,"tran1",7,100,u);
        Transaction t2 = new Transaction(2,"tran2",7,90,u);
        Transaction t3 = new Transaction(3,"tran3",8,200,u);
        Transaction t4 = new Transaction(4,"tran4",9,90,u);
        Transaction t5 = new Transaction(5,"tran5",9,200,u);

        trans.add(t1);trans.add(t2);trans.add(t3);trans.add(t4);trans.add(t5);

        hm.put(7,(double)45);
        hm.put(8,(double)250);
        hm.put(9,(double)145);
    }

    @Test
    public void testGetTransaction(){
//        TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
//        UserRepository userRepository = Mockito.mock(UserRepository.class);

        Mockito.when(transactionRepository.findByUserId(1)).thenReturn(trans);
        Mockito.when(userRepository.findById((long)1)).thenReturn(Optional.ofNullable(u));

        ReturnTransactionDto returnTransactionDto = transactionService.getTransactionFor3Month(1);
        Assertions.assertEquals(returnTransactionDto.getTotal_awards(),630);
        Assertions.assertEquals(returnTransactionDto.getAwards_per_month(),hm);
    }
}