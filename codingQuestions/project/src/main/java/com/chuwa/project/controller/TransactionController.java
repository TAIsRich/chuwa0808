package com.chuwa.project.controller;

import com.chuwa.project.payload.TransactionDto;
import com.chuwa.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/customers/{customer_id}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(value = "customer_id") Long id,
                                                            @RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionService.createTransaction(id, transactionDto), HttpStatus.CREATED);
    }


    @GetMapping("/customers/{customer_id}/transactions")
    public ResponseEntity<List<TransactionDto>> getAllTransByCID(@PathVariable(value = "customer_id") Long cid){
        List<TransactionDto> transactionDtos = transactionService.getTransactionByCustomerId(cid);
        return ResponseEntity.ok(transactionDtos);
    }


}
