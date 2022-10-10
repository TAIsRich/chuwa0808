package com.example.reward_system.payload;

import com.example.reward_system.entity.Transaction;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

public class CustomerDto {
    private long id;
    @NotEmpty(message = "Username should not be null or empty")
    private String username;
    @NotEmpty(message = "Phone number should not be null or empty")
    private String phone_number;
    private double reward;
    private Set<TransactionDto> transactions;

    public CustomerDto() {
    }

    public CustomerDto(long id, String username, String phone_number, Set<TransactionDto> transactions, double reward) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.transactions = transactions;
        this.reward = reward;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", transactions=" + transactions +
                ", reward=" + reward +
                '}';
    }
}
