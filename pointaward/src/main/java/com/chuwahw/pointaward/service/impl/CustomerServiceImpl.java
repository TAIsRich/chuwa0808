package com.chuwahw.pointaward.service.impl;

import com.chuwahw.pointaward.dao.CustomerRepository;
import com.chuwahw.pointaward.dao.PurchaseRepository;
import com.chuwahw.pointaward.entity.Customer;
import com.chuwahw.pointaward.entity.Purchase;
import com.chuwahw.pointaward.exception.ResourceNotFoundException;
import com.chuwahw.pointaward.payload.CustomerDto;
import com.chuwahw.pointaward.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto getTotalRewardPoint(String customerNameOrEmail) {

        Customer customer = customerRepository
                .findCustomerByNameOrEmail(customerNameOrEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerNameOrEmail", customerNameOrEmail));

        List<Purchase> purchases = purchaseRepository.findPurchasesByCustomer_NameOrCustomer_Email(customerNameOrEmail);
        Long rewardPoint50 = purchases.stream()
                .filter(purchase -> purchase.getPrice() > 50)
                .count();

        Double rewardPoint100 = purchases.stream()
                .mapToDouble(purchase -> (Math.max(purchase.getPrice(), 100) - 100) * 2)
                .sum();

        int totalRewardPoint =  (int)(rewardPoint50 + rewardPoint100);

        customer.setPoints(totalRewardPoint);
        Customer customerWithPointUpdate = customerRepository.save(customer);

        return modelMapper.map(customerWithPointUpdate, CustomerDto.class);


    }

    @Override
    public CustomerDto getMonthlyRewardPoint(String customerNameOrEmail, int month) {

        Customer customer = customerRepository
                .findCustomerByNameOrEmail(customerNameOrEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerNameOrEmail", customerNameOrEmail));

        List<Purchase> purchases = purchaseRepository.findPurchasesByCustomer_NameOrCustomer_Email(customerNameOrEmail);
        Long rewardPoint50 = purchases.stream()
                .filter(purchase -> purchase.getCreateDateTime().getMonthValue() == month)
                .filter(purchase -> purchase.getPrice() > 50)
                .count();

        Double rewardPoint100 = purchases.stream()
                .filter(purchase -> purchase.getCreateDateTime().getMonthValue() == month)
                .mapToDouble(purchase -> (Math.max(purchase.getPrice(), 100) - 100) * 2)
                .sum();

        int totalMonthlyRewardPoint =  (int)(rewardPoint50 + rewardPoint100);

        customer.setPoints(totalMonthlyRewardPoint);

        return modelMapper.map(customer, CustomerDto.class);

    }
}
