package com.example.rewardpoints.controller;

import com.example.rewardpoints.dto.CustomerDto;
import com.example.rewardpoints.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    private ResponseEntity<CustomerDto> getCustomer(@PathVariable("name") String name) {
        return ResponseEntity.ok(customerService.getCustomerByName(name));
    }

}
