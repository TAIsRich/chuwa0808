package com.chuwa.customerRewards.controller;

import com.chuwa.customerRewards.payload.PurchaseRecordDto;
import com.chuwa.customerRewards.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController     //= @Controller + @response
@RequestMapping("/api/v1")
public class PurchaseRecordController {
    @Autowired
    private PurchaseRecordService purchaseRecordService;

    @PostMapping("/customers/{customerId}/purchaseRecords")
    public ResponseEntity<PurchaseRecordDto> createPurchaseRecord(@PathVariable(value = "customerId") long id,
                                                                  @RequestBody PurchaseRecordDto purchaseRecordDto){
        return new ResponseEntity<>(purchaseRecordService.createPurchaseRecord(id, purchaseRecordDto), HttpStatus.CREATED);
    }
/*
    @GetMapping("/customers/{customerId}/purchaseRecords")
    public ResponseEntity<List<PurchaseRecordDto>> getPurchaseRecordByCustomerId(@PathVariable(name = "customerId") long customerId){
        List<PurchaseRecordDto> records = purchaseRecordService.getPurchaseRecordByCustomerId(customerId);
        return ResponseEntity.ok(records);
    }

 */

    @DeleteMapping("/customers/{customerId}/purchaseRecords/{purchaseRecordId}")
    public ResponseEntity<String> deletePurchaseRecordById(@PathVariable(name = "customerId") long customerId,
                                                           @PathVariable(name = "purchaseRecordId") long purchaseRecordId){
        purchaseRecordService.deletePurchaseRecord(customerId, purchaseRecordId);

        return new ResponseEntity<>("PurchaseRecord deleted Successfully!", HttpStatus.OK);
    }
}

