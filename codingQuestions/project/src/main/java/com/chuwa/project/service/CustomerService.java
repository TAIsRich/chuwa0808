package com.chuwa.project.service;

import com.chuwa.project.payload.CustomerDto;
import com.chuwa.project.payload.RewardDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();

    CustomerDto updateCustomer(CustomerDto customerDto, Long id);

    void deleteCustomer(Long id);

    RewardDto getRewardById(Long customerId);

    RewardDto getRewardByIdAndMonth(Long customerId, int month);


}
