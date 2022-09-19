package com.chuwahw.pointaward.dao;

import com.chuwahw.pointaward.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findPurchasesByCustomer_NameOrCustomer_Email(String customerNameOrEmail);




}
