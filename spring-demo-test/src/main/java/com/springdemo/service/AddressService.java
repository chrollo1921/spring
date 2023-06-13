package com.springdemo.service;

import com.springdemo.domain.Address;
import com.springdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }
}
