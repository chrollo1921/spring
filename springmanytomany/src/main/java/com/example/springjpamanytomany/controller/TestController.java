package com.example.springjpamanytomany.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/getTesting")
    public String getTest(){
        return "Testing the Spring Boot Application";
    }
}
