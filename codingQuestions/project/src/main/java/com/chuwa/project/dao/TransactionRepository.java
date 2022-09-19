package com.chuwa.project.dao;

import com.chuwa.project.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //List<Transaction> findByCustomerId(long cid);
    Optional<List<Transaction>> findByCustomerId(long cid);


}
