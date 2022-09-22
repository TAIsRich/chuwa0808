package com.chuwa.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long T_id;

    @Column(name = "amount", unique = false, nullable = false)
    private Double amount;



    @Column(name = "purchase_date", unique = false, nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    public Transaction() {
    }

    public Transaction(Long id, Double amount, LocalDate date) {
        this.T_id = id;
        this.amount = amount;
        this.date = date;
    }


    public Long getId() {
        return T_id;
    }

    public void setId(Long id) {
        this.T_id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "Transaction{" +
                "id=" + T_id +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
