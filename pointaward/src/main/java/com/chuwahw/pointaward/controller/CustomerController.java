package com.chuwahw.pointaward.controller;

import com.chuwahw.pointaward.payload.CustomerDto;
import com.chuwahw.pointaward.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{customerNameOrEmail}/totalpoints")
    public ResponseEntity<CustomerDto> getTotalAwardPoints(@PathVariable(value = "customerNameOrEmail") String customerNameOrEmail){
        return new ResponseEntity<>(customerService.getTotalRewardPoint(customerNameOrEmail), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerNameOrEmail}/points/{month}")
    public ResponseEntity<CustomerDto> getAwardPointsInMonth(@PathVariable(value = "customerNameOrEmail") String customerNameOrEmail,
                                                             @PathVariable(value = "month") int month){
        return new ResponseEntity<>(customerService.getMonthlyRewardPoint(customerNameOrEmail, month), HttpStatus.OK);
    }
}
