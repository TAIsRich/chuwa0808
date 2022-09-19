package com.chuwa.customerRewards.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * everytime there is a new input of (customerId, curAmount)
 * we create a new record with customerId, curAmount, time
 */
@Entity
@Table(name = "purchaseRecords")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private Double purchaseAmount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public PurchaseRecord() {
    }

    public PurchaseRecord(Long id, Double purchaseAmount, LocalDate date) {
        this.id = id;
        this.purchaseAmount = purchaseAmount;
        this.date = date;
    }

    public PurchaseRecord(Long id, Customer customer, Double purchaseAmount, LocalDate date) {
        this.id = id;
        this.customer = customer;
        this.purchaseAmount = purchaseAmount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", date=" + date +
                '}';
    }
}
