package com.example.rewardpoints.ServiceImpl;


import com.example.rewardpoints.dao.CustomerRepository;
import com.example.rewardpoints.dao.TransactionRepository;
import com.example.rewardpoints.dto.CustomerDto;
import com.example.rewardpoints.dto.TransactionDto;
import com.example.rewardpoints.entity.Customer;
import com.example.rewardpoints.entity.Transaction;
import com.example.rewardpoints.service.CustomerService;
import com.example.rewardpoints.service.TransactionService;
import com.example.rewardpoints.service.impl.CustomerServiceImpl;
import com.example.rewardpoints.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImplTest.class);

    @Mock
    private TransactionRepository transactionRepositoryMock;

    @Mock
    private CustomerRepository customerRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Transaction transaction;
    private TransactionDto transactionDto;
    private Customer customer;
    private CustomerDto customerDto;
    private List<Transaction> transactions;
    private List<TransactionDto> transactionDtos;
    @BeforeAll
    static void beforeAll(){
        logger.info("Start Transaction Test");
    }

    @BeforeEach
    void setUp(){
        customer = new Customer(1L, "mila");
        ModelMapper modelMapper = new ModelMapper();
        customerDto = modelMapper.map(customer, CustomerDto.class);
        transactions = new ArrayList<>();
        transaction = new Transaction(1L, 120.00, LocalDate.parse("2022-09-18"));
        Transaction transaction1 = new Transaction(2L, 100.00, LocalDate.parse("2022-07-18"));
        Transaction transaction2 = new Transaction(3L, 51.00, LocalDate.parse("2022-05-18"));
        transaction.setCustomer(customer);
        transaction.setReward(transactionService.calculateReward(transaction.getMoney()));
        transaction1.setCustomer(customer);
        transaction1.setReward(transactionService.calculateReward(transaction1.getMoney()));
        transaction2.setCustomer(customer);
        transaction2.setReward(transactionService.calculateReward(transaction2.getMoney()));
        transactions.add(transaction);
        transactions.add(transaction1);
        transactions.add(transaction2);
        customer.setTransactions(transactions);
        transactionDto = modelMapper.map(transaction, TransactionDto.class);
        transactionDtos = transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
    }

    @Test
    public void testCreateTransaction() {
        Mockito.when(customerRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(customer));

        Mockito.when(transactionRepositoryMock.save(ArgumentMatchers.any(Transaction.class))).thenReturn(transaction);
        TransactionDto transactionResponse = transactionService.createTransaction(customer.getId(), transactionDto);
        Assertions.assertNotNull(transactionResponse);
        Assertions.assertEquals(transactionDto.getMoney(), transactionResponse.getMoney());
        Assertions.assertEquals(transactionDto.getReward(), transactionResponse.getReward());
    }

    @Test
    public void testGetTransactionsByName(){
        Mockito.when(transactionRepositoryMock.findTransactionByCustomerName(ArgumentMatchers.anyString())).thenReturn(transactions);
        List<TransactionDto> threeMonthTransactions = new ArrayList<>();

        threeMonthTransactions.add(transactionDtos.get(0));
        threeMonthTransactions.add(transactionDtos.get(1));

        List<TransactionDto> transactionResponse = transactionService.getTransactionsByName(customer.getName());

        Assertions.assertNotNull(transactionResponse);
        Assertions.assertTrue(threeMonthTransactions.equals(transactionResponse));
    }

    @Test
    public void testGetRewardByMonth(){
        Mockito.when(customerRepositoryMock.findCustomerByName(ArgumentMatchers.anyString())).thenReturn(customer);
        Double reward = transactionService.getRewardByMonth(customer.getName(), "20220718");
        Assertions.assertEquals(reward, 50);

    }

    @Test
    public void testGetRewardTotal(){
        Mockito.when(customerRepositoryMock.findCustomerByName(ArgumentMatchers.anyString())).thenReturn(customer);
        Double reward = transactionService.getRewardTotal("mila");
        Assertions.assertEquals(reward, 141);

    }

}
