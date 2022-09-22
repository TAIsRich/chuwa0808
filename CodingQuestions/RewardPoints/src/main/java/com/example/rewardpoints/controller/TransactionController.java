package com.example.rewardpoints.controller;

import com.example.rewardpoints.dto.TransactionDto;
import com.example.rewardpoints.entity.Transaction;
import com.example.rewardpoints.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{customerId}")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(value = "customerId") Long customerId,
                                                            @RequestBody TransactionDto transactionDto) {
        return new ResponseEntity<>(transactionService.createTransaction(customerId, transactionDto), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public List<TransactionDto> getTransactionsByName(@PathVariable(value = "name") String name) {
        return transactionService.getTransactionsByName(name);
    }

    //  20190101
    @GetMapping("/{name}/{time}")
    public ResponseEntity<Double> getRewardByMonth(@PathVariable(value = "name") String name,
                                                   @PathVariable(value = "time") String time) {
        Double points = transactionService.getRewardByMonth(name, time);
        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @GetMapping("/reward/{name}")
    public ResponseEntity<Double> getRewardTotal(@PathVariable(value = "name") String name) {
        Double points = transactionService.getRewardTotal(name);
        return new ResponseEntity<>(points, HttpStatus.OK);
    }
}
