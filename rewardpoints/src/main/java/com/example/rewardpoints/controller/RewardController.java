package com.example.rewardpoints.controller;

import com.example.rewardpoints.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<BigDecimal> getPoints() {
        return new ResponseEntity<>(rewardService.getPoints(), new HttpHeaders(), HttpStatus.OK);
    }

}