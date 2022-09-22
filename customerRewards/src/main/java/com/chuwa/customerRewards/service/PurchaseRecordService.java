package com.chuwa.customerRewards.service;

import com.chuwa.customerRewards.payload.PurchaseRecordDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseRecordService {

    PurchaseRecordDto createPurchaseRecord (long customerId, PurchaseRecordDto purchaseRecordDto);

    List<PurchaseRecordDto> getPurchaseRecordByCustomerId(Long customerId);

    PurchaseRecordDto getPurchaseRecordById(long customerId, long purchaseRecordId);

//    PurchaseRecordDto updatePurchaseRecord(long customerId, long purchaseRecordId, PurchaseRecordDto purchaseRecordDto);

    void deletePurchaseRecord(long customerId, long purchaseRecordId);
}
