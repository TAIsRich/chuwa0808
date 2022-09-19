package com.example.demo.controller;

import com.example.demo.payload.ReturnTransactionDto;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reward")
public class RewardsController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/{user_id}/")
    public ResponseEntity<ReturnTransactionDto> calculateRewards(@PathVariable(name = "user_id") long user_id ){
        ReturnTransactionDto returnTransactionDto = transactionService.getTransactionFor3Month(user_id);
        return new ResponseEntity<>(returnTransactionDto, HttpStatus.OK);
    }



}
