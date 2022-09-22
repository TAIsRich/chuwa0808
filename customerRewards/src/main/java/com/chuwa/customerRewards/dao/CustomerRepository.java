package com.chuwa.customerRewards.dao;

import com.chuwa.customerRewards.entity.Customer;
import com.chuwa.customerRewards.entity.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //提数据，不对数据做操作


}
