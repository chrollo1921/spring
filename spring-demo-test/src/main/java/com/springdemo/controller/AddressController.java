package com.springdemo.controller;

import com.springdemo.domain.Address;
import com.springdemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAllAddress")
    public List<Address> getAddresses(){
        return addressService.getAddress();
    }

}
