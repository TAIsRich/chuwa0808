package com.example.reward_system.payload;

import javax.validation.constraints.NotEmpty;

public class TransactionDto {
    private long id;

    @NotEmpty(message = "Total price should not be null or empty")
    private double total_price;

    private double reward;

    public TransactionDto() {
    }

    public TransactionDto(long id, double total_price, double reward) {
        this.id = id;
        this.total_price = total_price;
        this.reward = reward;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", reward=" + reward +
                '}';
    }
}
