package com.chuwa.customerRewards.controller;

import com.chuwa.customerRewards.payload.CustomerDto;
import com.chuwa.customerRewards.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerResponse = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<Integer> getTotalPoints(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(customerService.getAllPoint(id));
    }

    @GetMapping("/{id}/monthPoint/{month}")
    public ResponseEntity<Integer> getPerMonthPoints(@PathVariable(name = "id") long id,
                                                     @PathVariable(name = "month") int month){
        return ResponseEntity.ok(customerService.getPerMonthPoint(id, month));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@RequestBody CustomerDto customerDto,
                                                          @PathVariable(name = "id") long id) {
        CustomerDto customerResponse = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
    }


}
