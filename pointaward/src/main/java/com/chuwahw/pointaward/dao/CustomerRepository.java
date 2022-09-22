package com.chuwahw.pointaward.dao;

import com.chuwahw.pointaward.entity.Customer;
import com.chuwahw.pointaward.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Customer findCustomerById(long customerId);

    Optional<Customer> findCustomerByNameOrEmail(String customerNameOrEmail);

}
