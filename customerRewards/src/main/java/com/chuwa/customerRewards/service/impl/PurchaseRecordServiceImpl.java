package com.chuwa.customerRewards.service.impl;

import com.chuwa.customerRewards.dao.CustomerRepository;
import com.chuwa.customerRewards.dao.PurchaseRecordRepository;
import com.chuwa.customerRewards.entity.Customer;
import com.chuwa.customerRewards.entity.PurchaseRecord;
import com.chuwa.customerRewards.exception.BlogAPIException;
import com.chuwa.customerRewards.exception.ResourceNotFoundException;
import com.chuwa.customerRewards.payload.PurchaseRecordDto;
import com.chuwa.customerRewards.service.PurchaseRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRecordRepository purchaseRecordRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PurchaseRecordDto createPurchaseRecord(long customerId, PurchaseRecordDto purchaseRecordDto) {
        PurchaseRecord purchaseRecord = modelMapper.map(purchaseRecordDto, PurchaseRecord.class);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        purchaseRecord.setCustomer(customer);
        PurchaseRecord savedPurchaseRecord = purchaseRecordRepository.save(purchaseRecord);
        return modelMapper.map(savedPurchaseRecord, PurchaseRecordDto.class);
    }

    @Override
    public List<PurchaseRecordDto> getPurchaseRecordByCustomerId(Long customerId) {
        List<PurchaseRecord> purchaseRecords = purchaseRecordRepository.findByCustomerId(customerId);
        List<PurchaseRecordDto> result = purchaseRecords.stream()
                .map(purchaseRecord -> modelMapper.map(purchaseRecord, PurchaseRecordDto.class))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public PurchaseRecordDto getPurchaseRecordById(long customerId, long purchaseRecordId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        PurchaseRecord purchaseRecord = purchaseRecordRepository.findById(purchaseRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("PurchaseRecord","id", purchaseRecordId));

        if(!purchaseRecord.getCustomer().getId().equals(customer.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "purchaseRecord does not belong to customer");
        }
        return modelMapper.map(purchaseRecord, PurchaseRecordDto.class);
    }

    @Override
    public void deletePurchaseRecord(long customerId, long purchaseRecordId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        PurchaseRecord purchaseRecord = purchaseRecordRepository.findById(purchaseRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("PurchaseRecord","id", purchaseRecordId));
        if(!purchaseRecord.getCustomer().getId().equals(customer.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "purchaseRecord does not belong to customer");
        }

        purchaseRecordRepository.delete(purchaseRecord);
    }
}
