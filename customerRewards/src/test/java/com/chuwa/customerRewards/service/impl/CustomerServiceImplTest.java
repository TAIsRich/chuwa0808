package com.chuwa.customerRewards.service.impl;

import com.chuwa.customerRewards.dao.CustomerRepository;
import com.chuwa.customerRewards.dao.PurchaseRecordRepository;
import com.chuwa.customerRewards.entity.Customer;
import com.chuwa.customerRewards.entity.PurchaseRecord;
import com.chuwa.customerRewards.exception.ResourceNotFoundException;
import com.chuwa.customerRewards.payload.CustomerDto;
import org.assertj.core.internal.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplTest.class);

    @Mock
    private PurchaseRecordRepository purchaseRecordRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

   // private CustomerDto customerDto;
    private Customer customer;



    List<PurchaseRecord> list;
    List<PurchaseRecord> list2;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Customer for each test");

        customer = new Customer(1L, "test@gmail.com", "test1","test");

        LocalDate date1 = LocalDate.of(2022, 1, 13);
        LocalDate date2 = LocalDate.of(2022, 1, 25);
        LocalDate date3 = LocalDate.of(2022, 2, 8);

        PurchaseRecord purchaseRecord1 = new PurchaseRecord(1L, customer,50.00, date1);
        PurchaseRecord purchaseRecord2 = new PurchaseRecord(2L, customer,100.00, date2);
        PurchaseRecord purchaseRecord3 = new PurchaseRecord(3L, customer,68.00, date3);

        list = new ArrayList<>();
        list.add(purchaseRecord1);
        list.add(purchaseRecord2);
        list.add(purchaseRecord3);

        list2 = new ArrayList<>();
        list2.add(purchaseRecord1);
        list2.add(purchaseRecord2);

    }

    @Test
    public void testGetAllPoint() {
        Mockito.when(purchaseRecordRepositoryMock.findByCustomerId(1L))
                .thenReturn(list);

        int result = customerService.getAllPoint(1L);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, 68);

    }

    @Test
    public void testGetPerMonthPoint(){
        Mockito.when(purchaseRecordRepositoryMock.findByUserIdAndMonth(1L, 1))
                .thenReturn(list2);
        int result2 = customerService.getPerMonthPoint(1L, 1);

        Assertions.assertNotNull(result2);
        Assertions.assertEquals(result2, 50);

    }
}

