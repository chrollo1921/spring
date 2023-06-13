package com.springdemo.dto;

import com.springdemo.domain.Person;

public class PersonDTO {

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "person=" + person +
                '}';
    }
}
