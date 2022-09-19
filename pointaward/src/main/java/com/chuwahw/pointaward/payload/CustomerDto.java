package com.chuwahw.pointaward.payload;

import com.chuwahw.pointaward.entity.Purchase;
import com.sun.istack.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class CustomerDto {

    private long id;

    @NotEmpty
    @Size(min = 5, message = "Customer name should have at least 5 characters")
    private String name;

    @NotEmpty(message = "Email is required")
    private String email;

    private Integer points;


    public CustomerDto(){
    }

    public CustomerDto(long id, String name, String email, Integer points) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.points = points;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
