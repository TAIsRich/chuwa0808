package com.example.customer.returnPoints.service;

import com.example.customer.returnPoints.payload.PointDto;
import com.example.customer.returnPoints.payload.PurchaseDto;


public interface PurchaseService {
    PointDto createRecord(Long id, PurchaseDto purchaseDto);
}
