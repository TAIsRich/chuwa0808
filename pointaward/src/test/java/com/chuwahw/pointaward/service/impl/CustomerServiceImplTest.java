package com.chuwahw.pointaward.service.impl;

import com.chuwahw.pointaward.dao.CustomerRepository;
import com.chuwahw.pointaward.dao.PurchaseRepository;
import com.chuwahw.pointaward.entity.Customer;
import com.chuwahw.pointaward.*;
import com.chuwahw.pointaward.entity.Purchase;
import com.chuwahw.pointaward.payload.CustomerDto;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplTest.class);

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PurchaseRepository purchaseRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    private CustomerDto customerDto;

    @BeforeAll
    static  void beforeAll(){
        logger.info("START Test");
    }

    @BeforeEach
    void setUp(){

        logger.info("set up customer for each test");

        Purchase purchase1 = Purchase.builder()
                .id(1)
                .customer(customer)
                .price(170.00) //70 * 2 + 1 = 141
                .createDateTime(LocalDateTime.parse("03/07/2022"))
                .build();

        Purchase purchase2 = Purchase.builder()
                .id(2)
                .customer(customer)
                .price(58.00) //1 point
                .createDateTime(LocalDateTime.parse("03/11/2022"))
                .build();

        Purchase purchase3 = Purchase.builder()
                .id(3)
                .customer(customer)
                .price(105.00) //5 * 2 + 1 = 11
                .createDateTime(LocalDateTime.parse("04/16/2022"))
                .build();

        Set<Purchase> purchases = Arrays.asList(purchase1, purchase2, purchase3)
                .stream()
                .collect(Collectors.toSet());

        customer = Customer.builder()
                .id(7)
                .name("theresa")
                .email("happy@gmail.com")
                .points(153)
                .purchases(purchases)
                .build();
    }

    @Test
    public void testGetTotalRewardPoint_byEmail() {

        //given - precondition or setup
        given(customerService.getTotalRewardPoint(anyString())).willReturn(modelMapper.map(customer, CustomerDto.class));

        // when - action or the behaviour that we are going test
        Integer points = customerService.getTotalRewardPoint(this.customer.getEmail()).getPoints();

        // then - verify the output
        Assertions.assertThat(points).isEqualTo(this.customer.getPoints());

    }

    @Test
    public void testGetTotalRewardPoint_byName() {

        //given - precondition or setup
        given(customerService.getTotalRewardPoint(anyString())).willReturn(modelMapper.map(customer, CustomerDto.class));

        // when - action or the behaviour that we are going test
        Integer points = customerService.getTotalRewardPoint(this.customer.getName()).getPoints();

        // then - verify the output
        Assertions.assertThat(points).isEqualTo(this.customer.getPoints());

    }

    @Test
    public void testGetMonthlyRewardPoint_byEmail() {

        int month = 3;

        //given - precondition or setup
        given(customerService.getTotalRewardPoint(anyString())).willReturn(modelMapper.map(customer, CustomerDto.class));

        // when - action or the behaviour that we are going test
        Integer points = customerService.getMonthlyRewardPoint(this.customer.getEmail(), month).getPoints();

        // then - verify the output
        Assertions.assertThat(points).isEqualTo(this.customer.getPoints());
    }

    @Test
    public void testGetMonthlyRewardPoint_byName() {

        int month = 3;

        //given - precondition or setup
        given(customerService.getTotalRewardPoint(anyString())).willReturn(modelMapper.map(customer, CustomerDto.class));

        // when - action or the behaviour that we are going test
        Integer points = customerService.getMonthlyRewardPoint(this.customer.getName(), month).getPoints();

        // then - verify the output
        Assertions.assertThat(points).isEqualTo(this.customer.getPoints());
    }
}