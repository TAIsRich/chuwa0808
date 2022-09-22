package com.chuwa.customerRewards.dao;

import com.chuwa.customerRewards.entity.Customer;
import com.chuwa.customerRewards.entity.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
    List<PurchaseRecord> findByCustomerId(long customerId);
    //SUBSTRING(cast(p.date as text), 5,7)
    @Query(value = "SELECT * FROM purchase_records p WHERE p.customer_id =:customerId AND year(p.date) = 2022 AND month(p.date) =:month", nativeQuery = true)
    List<PurchaseRecord> findByUserIdAndMonth(@Param("customerId") long customerId,
            @Param("month") int month);
}

/*

 */