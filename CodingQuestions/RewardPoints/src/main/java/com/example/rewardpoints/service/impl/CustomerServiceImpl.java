package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.dao.CustomerRepository;
import com.example.rewardpoints.dto.CustomerDto;
import com.example.rewardpoints.entity.Customer;
import com.example.rewardpoints.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByName(String name) {
        Customer customer = customerRepository.findCustomerByName(name);
        return modelMapper.map(customer, CustomerDto.class);
    }

}
