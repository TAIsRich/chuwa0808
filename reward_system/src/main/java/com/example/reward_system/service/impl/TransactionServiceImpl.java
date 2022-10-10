package com.example.reward_system.service.impl;

import com.example.reward_system.Exception.ResourceNotFoundException;
import com.example.reward_system.dao.CustomerRepository;
import com.example.reward_system.dao.TransactionRepository;
import com.example.reward_system.entity.Customer;
import com.example.reward_system.entity.Transaction;
import com.example.reward_system.payload.TransactionDto;
import com.example.reward_system.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransactionDto createTransaction(long customer_id, TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transaction.setReward();
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new ResourceNotFoundException("customer", "id", customer_id));
        transaction.setCustomer(customer);

        Transaction saved_transaction = transactionRepository.save(transaction);
        return modelMapper.map(saved_transaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = transactions.stream()
                .map(transaction-> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> getAllTransactionByCustomerId(long customer_id) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customer_id);
        List<TransactionDto> transactionDtos = transactions.stream()
                .map(transaction-> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public TransactionDto getTransactionById(long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("transaction", "id", id));
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto, long id) {
        Transaction t = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        t.setTotal_price(transactionDto.getTotal_price());
        t.setReward();

        Transaction transaction = transactionRepository.save(t);
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public void deleteTransaction(long id) {
        Transaction t = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        transactionRepository.delete(t);
    }
}
