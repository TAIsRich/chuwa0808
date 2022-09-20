package com.example.rewardpoints.service;

import com.example.rewardpoints.dto.CustomerDto;


public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerByName(String name);

}
