package com.example.reward_system.controller;

import com.example.reward_system.payload.CustomerDto;
import com.example.reward_system.payload.TransactionDto;
import com.example.reward_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable (name = "id") long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable (name = "id") long id,
                                                          @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable (name = "id") long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity("Customer is deleted successfully", HttpStatus.OK);
    }
}
