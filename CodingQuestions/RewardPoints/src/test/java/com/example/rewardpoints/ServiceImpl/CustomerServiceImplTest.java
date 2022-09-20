package com.example.rewardpoints.ServiceImpl;

import com.example.rewardpoints.dao.CustomerRepository;
import com.example.rewardpoints.dto.CustomerDto;
import com.example.rewardpoints.entity.Customer;
import com.example.rewardpoints.service.impl.CustomerServiceImpl;
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

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplTest.class);

    @Mock
    private CustomerRepository customerRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private CustomerDto customerDto;
    private Customer customer;

    @BeforeAll
    static void beforeAll(){
        logger.info("Start Customer Test");
    }

    @BeforeEach
    void setUp(){
        logger.info("set up customer for each test");
        this.customer = new Customer(1L, "mila");
        ModelMapper modelMapper = new ModelMapper();
        this.customerDto = modelMapper.map(customer, CustomerDto.class);
    }

    @Test
    public void testCreateCustomer(){
        Mockito.when(customerRepositoryMock.save(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        CustomerDto customerResponse = customerService.createCustomer(customerDto);

        Assertions.assertNotNull(customerResponse);
        Assertions.assertEquals(customerDto.getName(), customerResponse.getName());
        Assertions.assertEquals(customerDto.getTransactions(), customerResponse.getTransactions());
    }

    @Test
    public void testGetCustomerByName(){
        Mockito.when(customerRepositoryMock.findCustomerByName(ArgumentMatchers.anyString())).thenReturn(customer);

        CustomerDto customerResponse = customerService.getCustomerByName("mila");

        Assertions.assertNotNull(customerResponse);
        Assertions.assertEquals(customerDto.getTransactions(), customerResponse.getTransactions());
    }

}
