package com.chuwa.reward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuwa.reward.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("api/v1/reward")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/{username}")
    public ResponseEntity<String> getTotleReward(@PathVariable String username){
        int credit = userServiceImpl.getReward(username);
        return new ResponseEntity<>(username + "'s total reward is " + credit, HttpStatus.OK);
    }

    @PostMapping("/{username}/{month}")
    public ResponseEntity<String> getMonthReward(@PathVariable String username ,@PathVariable int month){
        int credit = userServiceImpl.getMonthReward(username,month);
        return new ResponseEntity<>(username + "'s total reward is " + credit, HttpStatus.OK);
    }
}