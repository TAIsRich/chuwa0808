package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("api/v1/reward")
public class UserController {
    
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/{name}")
    public ResponseEntity<String> getTotleReward(@PathVariable String name){
        int credit = userServiceImpl.getTotleReward(name);
        return new ResponseEntity<>(name + "'s total reward is " + credit, HttpStatus.OK);
    }

    @PostMapping("/{name}/{month}")
    public ResponseEntity<String> getMonthReward(@PathVariable String name ,@PathVariable int month){
        int credit = userServiceImpl.getMonthReward(name,month);
        return new ResponseEntity<>(name + "'s total reward is " + credit, HttpStatus.OK);
    }

}
