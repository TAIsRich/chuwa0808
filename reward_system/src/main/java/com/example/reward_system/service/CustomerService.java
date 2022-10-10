package com.example.reward_system.service;

import com.example.reward_system.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(long id);
    List<CustomerDto> getAllCustomer();
    CustomerDto updateCustomer(CustomerDto customerDto, long id);
    void deleteCustomer(long id);
}
