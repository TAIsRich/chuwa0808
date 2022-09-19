package com.chuwa.project.controller;


import com.chuwa.project.payload.CustomerDto;
import com.chuwa.project.payload.RewardDto;
import com.chuwa.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerResponse = customerService.createCustomer(customerDto);

        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }


    //get the total points and the points of current month
    @GetMapping("/{id}/Rewards")
    public ResponseEntity<RewardDto> getTotalReward(@PathVariable(name = "id") Long id){


        try{
            RewardDto rewardDto;

            rewardDto = customerService.getRewardById(id);

            if(rewardDto == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rewardDto, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }


    @GetMapping("/{id}/Reward")
    public ResponseEntity<RewardDto> getRewardByMonth(@PathVariable(name = "id") Long id,
                                                    @RequestParam(value = "month") int month){

            try{
                RewardDto rewardDto;
                rewardDto = customerService.getRewardByIdAndMonth(id, month);
                if(rewardDto == null){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(rewardDto, HttpStatus.CREATED);
            } catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll(){
        List<CustomerDto> customerDtos = customerService.getAllCustomers();

        return ResponseEntity.ok(customerDtos);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable(name = "id") Long id){
        CustomerDto customerDto1 = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<>(customerDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id")long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer entity deleted successfully.", HttpStatus.OK);
    }

}
