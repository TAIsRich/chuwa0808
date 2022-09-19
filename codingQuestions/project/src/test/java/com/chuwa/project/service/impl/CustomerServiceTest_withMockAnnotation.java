package com.chuwa.project.service.impl;

import com.chuwa.project.dao.CustomerRepository;
import com.chuwa.project.dao.TransactionRepository;
import com.chuwa.project.entity.Customer;
import com.chuwa.project.entity.Transaction;
import com.chuwa.project.payload.CustomerDto;
import com.chuwa.project.payload.RewardDto;
import com.chuwa.project.payload.TransactionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest_withMockAnnotation {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceTest_withMockAnnotation.class);


    @Mock
    private CustomerRepository customerRepositoryMock;

    @Mock
    private TransactionRepository transactionRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CustomerImpl customerImpl;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private Customer customer;
    private CustomerDto customerDto;

    private List<Transaction> transactions;




    @BeforeAll
    static void beforeAll(){
        logger.info("START test");
    }

    @BeforeEach
    void setUp(){
        logger.info("set up the customer and the transactions for each test");

        customer = new Customer(1L,"test@mail.com", "Test", "Test");


        LocalDate date1 = LocalDate.parse("2022-07-03");
        LocalDate date2 = LocalDate.parse("2022-08-03");
        LocalDate date3 = LocalDate.parse("2022-09-03");
        Transaction t1 = new Transaction(1L, 99., date1);
        Transaction t2 = new Transaction(2L, 55., date2);
        Transaction t3 = new Transaction(3L, 78., date3);
        t1.setCustomer(customer);
        t1.setCustomer(customer);
        t1.setCustomer(customer);

        ModelMapper modelMapper = new ModelMapper();

        this.customerDto = modelMapper.map(customer, CustomerDto.class);
        this.transactions = new ArrayList<>();
        this.transactions.add(t1);
        this.transactions.add(t2);
        this.transactions.add(t3);



    }

    @Test
    public void testGetRewardById(){

        Mockito.when(transactionRepositoryMock.findByCustomerId(1L))
                .thenReturn(Optional.of(transactions));

        Mockito.when(customerRepositoryMock.findById(1L))
                .thenReturn(Optional.of(customer));


        RewardDto rewardDto = customerImpl.getRewardById(1L);
        RewardDto rewardDto1 = customerImpl.getRewardByIdAndMonth(1L, 9);

        Assertions.assertNotNull(rewardDto);

        Assertions.assertEquals(rewardDto.getTotalPoints(), 82);
        Assertions.assertEquals(rewardDto.getCurrMonthPoints(), 28);
        Assertions.assertEquals(rewardDto1.getTotalPoints(), 28);

    }






}
