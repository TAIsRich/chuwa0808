package com.example.customer.returnPoints.controller;

import com.example.customer.returnPoints.payload.PointDto;
import com.example.customer.returnPoints.payload.PurchaseDto;
import com.example.customer.returnPoints.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/returnPoints")
public class PointsReturnController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/{id}")
    public ResponseEntity<PointDto> returnPoints(@PathVariable long id, @RequestBody PurchaseDto purchaseDto){
        PointDto returnPoint = purchaseService.createRecord(id, purchaseDto);
        return new ResponseEntity<>(returnPoint, HttpStatus.OK);
    }
}
