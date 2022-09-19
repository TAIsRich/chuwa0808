package com.example.demo.entity;

import com.example.demo.entity.security.User;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int month;

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transaction(long id, String name, int month, double price, User user) {
        this.id = id;
        this.name = name;
        this.month = month;
        this.price = price;
        this.user = user;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable=false)
    private User user;


    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
