package com.example.demo.payload;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.security.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnTransactionDto {
    private User user;
    private double total_awards;
    private HashMap<Integer, Double> awards_per_month;

    public ReturnTransactionDto() {
    }

    public ReturnTransactionDto(User user, double total_awards, HashMap<Integer, Double> awards_per_month) {
        this.user = user;
        this.total_awards = total_awards;
        this.awards_per_month = awards_per_month;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal_awards() {
        return total_awards;
    }

    public void setTotal_awards(double total_awards) {
        this.total_awards = total_awards;
    }

    public HashMap<Integer, Double> getAwards_per_month() {
        return awards_per_month;
    }

    public void setAwards_per_month(HashMap<Integer, Double> awards_per_month) {
        this.awards_per_month = awards_per_month;
    }
}
