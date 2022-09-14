package com.chuwa.springMvcDemo.service;

import com.chuwa.springMvcDemo.dao.CustomerDAO;
import com.chuwa.springMvcDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);

    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {

        customerDAO.deleteCustomer(theId);

    }
}
