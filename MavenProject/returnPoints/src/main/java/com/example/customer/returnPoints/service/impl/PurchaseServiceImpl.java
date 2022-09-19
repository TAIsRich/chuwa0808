package com.example.customer.returnPoints.service.impl;

import com.example.customer.returnPoints.dao.PointRepository;
import com.example.customer.returnPoints.dao.PurchaseRepository;
import com.example.customer.returnPoints.entity.Point;
import com.example.customer.returnPoints.entity.Purchase;
import com.example.customer.returnPoints.payload.PointDto;
import com.example.customer.returnPoints.payload.PurchaseDto;
import com.example.customer.returnPoints.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PointDto createRecord(Long id, PurchaseDto purchaseDto) {

        purchaseDto.setCustomerId(id);
        Purchase purchase = modelMapper.map(purchaseDto, Purchase.class);
        Purchase purchaseResponse = purchaseRepository.save(purchase);
        Point point = new Point();
        point.setPoint(CalculatePoints(purchaseResponse.getAmount()));
        point.setPurchase(purchaseResponse);
        Point savedPoint = pointRepository.save(point);

        return modelMapper.map(savedPoint, PointDto.class);
    }

    public double CalculatePoints(double point){
        int res = 0;
        if(point > 50 && point <= 100){
            res += point-50;
        }
        if(point > 100){
            res += ((point-100)*2)+50;
        }
        return res;
    }
}
