package com.example.service;

import com.example.dto.ResponseResult;

public interface UserService{

    ResponseResult getTotleReward(String username);

    ResponseResult getMonthReward(String username, int month);

}
