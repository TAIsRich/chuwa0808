package com.example.controller;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseResult;
import com.example.service.Impl.UserServiceImpl;

@Validated
@RestController
@RequestMapping("api/v1/reward")
public class UserController {
    
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/{name}")
    public ResponseResult getTotleReward(@PathVariable @NotNull String name){
      return userServiceImpl.getTotleReward(name);
    }

    @PostMapping("/{name}/{month}")
    public ResponseResult getMonthReward(@PathVariable @NotNull String name ,@PathVariable @Range(min = 1,max = 12) int month){
        return userServiceImpl.getMonthReward(name, month);
    }

}
