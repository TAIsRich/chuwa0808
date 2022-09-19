package com.chuwa.customerRewards.service.impl;

import com.chuwa.customerRewards.dao.CustomerRepository;
import com.chuwa.customerRewards.dao.PurchaseRecordRepository;
import com.chuwa.customerRewards.entity.Customer;
import com.chuwa.customerRewards.entity.PurchaseRecord;
import com.chuwa.customerRewards.exception.ResourceNotFoundException;
import com.chuwa.customerRewards.payload.CustomerDto;
import com.chuwa.customerRewards.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRecordRepository purchaseRecordRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = modelMapper.map(customerDto, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomer(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id", id));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());
        customer.setEmail(customerDto.getEmail());

        Customer updateCustomer = customerRepository.save(customer);
        return modelMapper.map(updateCustomer, CustomerDto.class);
    }

    @Override
    public void deleteCustomerById(long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id", id));
        customerRepository.delete(customer);
    }

    @Override
    public int getAllPoint(long id){
        // Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id", id));
        List<PurchaseRecord> purchaseRecords = purchaseRecordRepository.findByCustomerId(id);
        return getPoint(purchaseRecords);
    }

    @Override
    public int getPerMonthPoint(long id, int month){
        //  customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id", id));
        List<PurchaseRecord> purchaseRecords = purchaseRecordRepository.findByUserIdAndMonth(id, month);
        return getPoint(purchaseRecords);
    }

    private int getPoint(List<PurchaseRecord> list) {
        int result = 0;
        for(PurchaseRecord record : list){
            Double cur = record.getPurchaseAmount();
            if(cur >= 50 && cur <= 100){
                result += cur - 50;
            }
            if(cur > 100){
                result += (cur - 100) * 2;
            }
        }
        return result;
    }
}
