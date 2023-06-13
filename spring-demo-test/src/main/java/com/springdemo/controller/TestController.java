package com.springdemo.controller;

import com.springdemo.service.RestConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RestConsumerService restConsumerService;

    @GetMapping("/getToken")
    public String getAccessToken(){
        return restConsumerService.oAuthGetter();
    }
}
