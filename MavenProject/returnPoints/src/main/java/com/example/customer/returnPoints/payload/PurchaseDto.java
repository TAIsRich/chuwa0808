package com.example.customer.returnPoints.payload;

public class PurchaseDto {

    private Long Id;

    private Long customerId;
    private double amount;

    public PurchaseDto() {
    }

    public PurchaseDto(Long id, Long customerId, double amount) {
        Id = id;
        this.customerId = customerId;
        this.amount = amount;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "Id=" + Id +
                ", customerId=" + customerId +
                ", amount=" + amount +
                '}';
    }
}
