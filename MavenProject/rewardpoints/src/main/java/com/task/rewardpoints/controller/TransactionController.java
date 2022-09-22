package com.task.rewardpoints.controller;

import com.task.rewardpoints.dto.RewardResponse;
import com.task.rewardpoints.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions/rewards")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<RewardResponse> getRewardsById(@RequestParam(name = "customerId") long customerId) {
        return ResponseEntity.ok(transactionService.getRewards(customerId));
    }
}
