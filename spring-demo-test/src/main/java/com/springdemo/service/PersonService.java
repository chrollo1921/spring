package com.springdemo.service;

import com.springdemo.domain.Person;
import com.springdemo.dto.PersonDTO;
import com.springdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person savePerson(PersonDTO personDTO){
        return personRepository.save(personDTO.getPerson());
    }
}
