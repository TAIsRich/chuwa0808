package com.chuwa.project.dao;

import com.chuwa.project.entity.Customer;
import com.chuwa.project.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //List<Transaction> findByIdOrEmail(Long id, String emial);




}
