package com.example.reward_system.dao;

import com.example.reward_system.entity.Customer;
import com.example.reward_system.payload.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
