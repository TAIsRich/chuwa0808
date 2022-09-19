package com.chuwa.project.service.impl;


import com.chuwa.project.dao.CustomerRepository;
import com.chuwa.project.dao.TransactionRepository;
import com.chuwa.project.entity.Customer;
import com.chuwa.project.entity.Transaction;
import com.chuwa.project.exception.customerNotFoundException;
import com.chuwa.project.payload.TransactionDto;
import com.chuwa.project.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TransactionDto createTransaction(Long cid, TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        Customer customer = customerRepository.findById(cid).orElseThrow(() -> new customerNotFoundException("Transaction", "id", cid));
        transaction.setCustomer(customer);

        Transaction saveTrans = transactionRepository.save(transaction);

        return modelMapper.map(saveTrans, TransactionDto.class);
    }

    @Override
    public TransactionDto getALLTransactionsByTransId(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new customerNotFoundException("Transaction", "id", id));
        TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);

        return transactionDto;
    }

    @Override
    public List<TransactionDto> getTransactionByCustomerId(Long cid) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(cid).orElseThrow(() -> new customerNotFoundException("Transaction", "id", cid));;

        List<TransactionDto> transactionDtos = transactions.stream()
                .map(t -> modelMapper.map(t, TransactionDto.class))
                .collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public TransactionDto upateTransaction(Long trans_id, TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.findById(trans_id).orElseThrow(() -> new customerNotFoundException("Transaction", "id", trans_id));
        transaction.setDate(transactionDto.getDate());
        transaction.setAmount(transactionDto.getAmount());

        transactionRepository.save(transaction);
        TransactionDto transactionDto1 = modelMapper.map(transaction, TransactionDto.class);

        return transactionDto1;
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new customerNotFoundException("Transaction", "id", id));
        transactionRepository.delete(transaction);

    }


}
