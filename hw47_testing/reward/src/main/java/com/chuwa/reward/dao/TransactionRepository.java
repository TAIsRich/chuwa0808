package com.chuwa.reward.dao;

import com.chuwa.reward.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);

    @Query(value = "SELECT * FROM `transaction` WHERE user_id = ?1 and year(date)=2022 and month(date) = ?2", nativeQuery = true)
    List<Transaction> findByUserIdAndMonth(Long userId, int month);

}
