package com.chuwahw.pointaward.controller;

import com.chuwahw.pointaward.dao.CustomerRepositoryTest;
import com.chuwahw.pointaward.entity.Customer;
import com.chuwahw.pointaward.entity.Purchase;
import com.chuwahw.pointaward.payload.CustomerDto;
import com.chuwahw.pointaward.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
public class CustomerControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);

    @Resource
    private MockMvc mockMvc;

    @Resource
    private ModelMapper modelMapper;

    @MockBean
    private CustomerService customerService;

    @Resource
    private ObjectMapper objectMapper;

    private Customer customer;

    private Purchase purchase;

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
    public void getTotalAwardPoints() throws Exception{
        //given - precondition or setup
        String emailOrName = "theresa";
        given(customerService.getTotalRewardPoint(emailOrName)).willReturn(modelMapper.map(customer, CustomerDto.class));

        ResultActions response = mockMvc.perform(get("/api/v1/customers/{customerNameOrEmail}/totalpoints", emailOrName));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(customer.getName())))
                .andExpect(jsonPath("$.email", is(customer.getEmail())))
                .andExpect(jsonPath("$.points", is(customer.getPoints())));
    }

    @Test
    public void getAwardPointsInMonth() throws Exception{

        String emailOrName = "theresa";
        int month = 3;

        given(customerService.getTotalRewardPoint(emailOrName)).willReturn(modelMapper.map(customer, CustomerDto.class));

        ResultActions response = mockMvc.perform(get("/api/v1/customers/{customerNameOrEmail}/points/{month}", emailOrName, month));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(customer.getName())))
                .andExpect(jsonPath("$.email", is(customer.getEmail())))
                .andExpect(jsonPath("$.points", is(customer.getPoints())));

    }
}