package com.springdemo.repository;

import com.springdemo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{
}
