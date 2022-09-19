package com.chuwa.customerRewards.payload;


import com.chuwa.customerRewards.entity.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * for each id, we need to pull out all the purchase record with purchase amount, and purchase date
 */
public class PurchaseRecordDto {
    private Long id;
    private Double purchaseAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Customer customer;

    public PurchaseRecordDto() {
    }

    public PurchaseRecordDto(Long id, Double purchaseAmount, LocalDate date) {
        this.id = id;
        this.purchaseAmount = purchaseAmount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PurchaseRecordDto{" +
                "id=" + id +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", date=" + date +
                '}';
    }
}
