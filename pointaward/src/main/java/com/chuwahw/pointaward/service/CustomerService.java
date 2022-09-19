package com.chuwahw.pointaward.service;

import com.chuwahw.pointaward.payload.CustomerDto;

public interface CustomerService {

    CustomerDto getTotalRewardPoint(String customerNameOrEmail);

    CustomerDto getMonthlyRewardPoint(String customerNameOrEmail, int month);

}
