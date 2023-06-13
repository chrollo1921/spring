package com.springdemo.controller;

import com.springdemo.domain.Person;
import com.springdemo.dto.PersonDTO;
import com.springdemo.repository.AddressRepository;
import com.springdemo.repository.PersonRepository;
import com.springdemo.service.AddressService;
import com.springdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private PersonService personService;

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody PersonDTO person){
        System.out.println("Person:: " + person.toString());
        return personService.savePerson(person);
        //return personRepository.save(person.getPerson());
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons(){
        System.out.println("Running /getAllPersons");
        //return personRepository.findAll();
        return personService.getAllPersons();
    }
}
