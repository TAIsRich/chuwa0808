package com.example.reward_system.controller;

import com.example.reward_system.payload.TransactionDto;
import com.example.reward_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class transcationController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping ("/customers/{customer_id}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(value = "customer_id") long id,
                                                            @RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionService.createTransaction(id, transactionDto), HttpStatus.CREATED);
    }

    @GetMapping("/transactions")
    public List<TransactionDto> getAllTransaction(){
        return transactionService.getAllTransaction();
    }

    @GetMapping("/customers/{customer_id}/transactions")
    public List<TransactionDto> getTransactionByCustomerId(@PathVariable(value = "customer_id") long id){
        return transactionService.getAllTransactionByCustomerId(id);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<TransactionDto> updateTransactionById(@PathVariable(value = "id") long id,
                                                                @RequestBody TransactionDto transactionDto){
        TransactionDto updateTransaction = transactionService.updateTransaction(transactionDto, id);
        return new ResponseEntity<>(updateTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> updateTransactionById(@PathVariable(value = "id") long id){
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>("Transaction is deleted successfully", HttpStatus.OK);
    }
}
