package com.example.reward_system.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "total_price")
    private double total_price;

    @CreationTimestamp
    @Column(name = "date_time")
    private LocalDateTime date_time;

    @Column(name = "reward")
    private double reward;

    public Transaction() {
    }

    public Transaction(long id, Customer customer, double total_price, LocalDateTime date_time) {
        this.id = id;
        this.customer = customer;
        this.total_price = total_price;
        this.date_time = date_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public double getReward() {
        return reward;
    }

    public void setReward() {
        this.reward = (this.total_price > 100) ? (this.total_price-100)*2 : 0;
        this.reward += (this.total_price > 50) ? (this.total_price-50) : 0;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customer=" + customer +
                ", total_price=" + total_price +
                ", date_time=" + date_time +
                ", reward=" + reward +
                '}';
    }
}
