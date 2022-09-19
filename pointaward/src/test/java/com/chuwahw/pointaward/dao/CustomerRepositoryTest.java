package com.chuwahw.pointaward.dao;

import com.chuwahw.pointaward.entity.Customer;
import com.chuwahw.pointaward.service.impl.CustomerServiceImplTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeAll
    static  void beforeAll(){
        logger.info("START Test");
    }

    @BeforeEach
    void setUp(){

        logger.info("set up customer for each test");

        customer = Customer.builder()
                .id(7)
                .name("theresa")
                .email("happy@gmail.com")
                .build();
    }

    @DisplayName("get customer by email or name - email")
    @Test
    public void findCustomerByNameOrEmail_Email() {

        //given - precondition or setup
        customerRepository.save(customer);

        // when -  action or the behaviour that we are going test
        Customer customer1 = customerRepository.findCustomerByNameOrEmail(customer.getEmail()).get();

        // then - verify the output
        assertThat(customer1).isNotNull();

    }
    @DisplayName("get customer by email or name - name")
    @Test
    public void findCustomerByNameOrEmail_Name() {

        //given - precondition or setup
        customerRepository.save(customer);

        // when -  action or the behaviour that we are going test
        Customer customer1 = customerRepository.findCustomerByNameOrEmail(customer.getName()).get();

        // then - verify the output
        assertThat(customer1).isNotNull();

    }
}