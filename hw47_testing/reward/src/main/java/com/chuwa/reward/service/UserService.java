package com.chuwa.reward.service;

public interface UserService {
    int getReward(String username);

    int getMonthReward(String username, int month);
}
