package com.chuwa.customerRewards.service;

import com.chuwa.customerRewards.payload.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();


    CustomerDto getCustomerById(long id);

    void deleteCustomerById(long id);

    CustomerDto updateCustomer(CustomerDto customerDto, long id);

    int getAllPoint(long id);

    int getPerMonthPoint(long id, int month);

}
