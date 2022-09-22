package com.chuwa.project.service.impl;

import com.chuwa.project.dao.CustomerRepository;
import com.chuwa.project.dao.TransactionRepository;
import com.chuwa.project.entity.Customer;
import com.chuwa.project.entity.Transaction;
import com.chuwa.project.exception.customerNotFoundException;
import com.chuwa.project.payload.CustomerDto;
import com.chuwa.project.payload.RewardDto;
import com.chuwa.project.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.chuwa.project.util.DateConstants.*;

@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer saveCustomer = customerRepository.save(customer);

        return modelMapper.map(saveCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new customerNotFoundException("Customer", "id", id));

        customer.setEmail(customerDto.getEmail());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        Customer saveCustomer = customerRepository.save(customer);

        return modelMapper.map(customer, CustomerDto.class);

    }

    @Override
    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new customerNotFoundException("Customer", "id", id));

        customerRepository.delete(customer);
    }

    @Override
    public RewardDto getRewardById(Long customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId).orElseThrow(
                () -> new customerNotFoundException("Customer", "id", customerId));;
        LocalDate today = LocalDate.now();
        int point = getPoint(transactions, today, DEFAULT_THREE_MONTHS);
        int current = getPoint(transactions, today.minusMonths(DEFAULT_ONE), DEFAULT_ZERO);


        RewardDto rewardDto = new RewardDto(customerId, point, current);
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new customerNotFoundException("Transaction", "id", customerId));
        customer.setRewardPoints(point);
        customerRepository.save(customer);

        return rewardDto;
    }

    @Override
    public RewardDto getRewardByIdAndMonth(Long customerId, int month) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId).orElseThrow(() -> new customerNotFoundException("Transaction", "id", customerId));
        int point = transactions
                .stream()
                .filter(t -> t.getDate().getMonthValue() == month)
                .map(t -> calPoints(t.getAmount()))
                .reduce(0, Integer::sum);

        return new RewardDto(customerId, point, point);
    }


    private int getPoint( List<Transaction> trans, LocalDate date, int range){
        int point = trans
                .stream()
                .filter(t -> t.getDate().plusMonths(range).isAfter(date)
                        || t.getDate().plusMonths(range) == date)
                .map(t -> calPoints(t.getAmount()))
                .reduce(0, Integer::sum);


        return point;

    }
    private int calPoints(Double amount){
        int point  = DEFAULT_ZERO;
        if(amount > DEFAULT_ONE_HUNDRED){
            point = (int) (DEFAULT_TWO * (amount - DEFAULT_ONE_HUNDRED));
        }else if(amount > DEFAULT_HALF_HUNDRED){
            point = (int) (DEFAULT_ONE * (amount - DEFAULT_HALF_HUNDRED));
        }
        return point;
    }




}
