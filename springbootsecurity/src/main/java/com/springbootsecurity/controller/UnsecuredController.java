package com.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UnsecuredController {

    @GetMapping("/home")
    public String getHome(){
        return "This is home page";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "This is Login Page";
    }
}
