package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.dao.CustomerRepository;
import com.example.rewardpoints.dao.TransactionRepository;
import com.example.rewardpoints.dto.TransactionDto;
import com.example.rewardpoints.entity.Customer;
import com.example.rewardpoints.entity.Transaction;
import com.example.rewardpoints.exception.ResourceNotFoundException;
import com.example.rewardpoints.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TransactionDto createTransaction(Long customerId, TransactionDto transactionDto) {

        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        transaction.setCustomer(customer);
        transaction.setReward(calculateReward(transaction.getMoney()));
        Transaction savedTransaction = transactionRepository.save(transaction);
        return modelMapper.map(savedTransaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getTransactionsByName(String name) {

        List<Transaction> transactions = transactionRepository.findTransactionByCustomerName(name);
        List<Transaction> threeMonthTransactions = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate minus = now.minusMonths(3);
        for (Transaction transaction : transactions) {
            LocalDate time = transaction.getCreateDateTime();
            if (time.isAfter(minus)) {
                threeMonthTransactions.add(transaction);
            }
        }
        return threeMonthTransactions.stream().map(threeMonthTransaction -> modelMapper.map(threeMonthTransaction, TransactionDto.class)).collect(Collectors.toList());
    }


    //20190101
    @Override
    public Double getRewardByMonth(String name, String time) {
        Double points = 0.00;

        LocalDate formatted = LocalDate.parse(time, DateTimeFormatter.BASIC_ISO_DATE);
        Customer customer = customerRepository.findCustomerByName(name);
        List<Transaction> transactions = customer.getTransactions();

        for(Transaction transaction : transactions) {
            int month = transaction.getCreateDateTime().getMonthValue();
            int year = transaction.getCreateDateTime().getYear();
            int monthInput = formatted.getMonthValue();
            int yearInput = formatted.getYear();

            if(month == monthInput && year == yearInput){
                points = points + transaction.getReward();
            }
        }
        return points;
    }

    @Override
    public Double getRewardTotal(String name) {
        Double total = 0.00;
        Customer customer = customerRepository.findCustomerByName(name);
        List<Transaction> transaction = customer.getTransactions();
        for(Transaction t : transaction) {
            total = total + t.getReward();
        }

        return total;
    }

    @Override
    public Double calculateReward(Double money) {
        double reward = 0.00;

        if(money >= 50 && money < 100){
            reward += (money - 50);
        }if(money >= 100.00){
            reward += (2*(money - 100) + 50);
        }
        return reward;
    }





}
