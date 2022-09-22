package com.example.demo.payload;

import com.example.demo.entity.security.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TransactionDto {
    private Long id;
    private String name;
    private int month;
    private User user;

    public TransactionDto() {
    }

    public TransactionDto(Long id, String name, int month, User user) {
        this.id = id;
        this.name = name;
        this.month = month;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
