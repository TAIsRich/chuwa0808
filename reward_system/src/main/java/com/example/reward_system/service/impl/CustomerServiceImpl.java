package com.example.reward_system.service.impl;

import com.example.reward_system.Exception.ResourceNotFoundException;
import com.example.reward_system.dao.CustomerRepository;
import com.example.reward_system.dao.TransactionRepository;
import com.example.reward_system.entity.Customer;
import com.example.reward_system.entity.Transaction;
import com.example.reward_system.payload.CustomerDto;
import com.example.reward_system.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer saved_customer = customerRepository.save(customer);
        return modelMapper.map(saved_customer, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        updateReward(id, customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers){
            updateReward(customer.getId(), customer);
        }
        List<CustomerDto> customerDtos = customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        customer.setPhone_number(customerDto.getPhone_number());
        customer.setUsername(customerDto.getUsername());

        Customer updatedCustomer = customerRepository.save(customer);
        return modelMapper.map(updatedCustomer, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        customerRepository.delete(customer);
    }

    private void updateReward(long id, Customer customer){
        List<Transaction> transactions = transactionRepository.findByCustomerId(id);
        double reward = transactions.stream()
                .map(transaction -> transaction.getReward())
                .reduce((double)0, (a,b) -> a+b);
        customer.setReward(reward);
        customerRepository.save(customer);
    }
}
