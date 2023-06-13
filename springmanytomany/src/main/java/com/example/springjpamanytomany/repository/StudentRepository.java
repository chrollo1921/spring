package com.example.springjpamanytomany.repository;

import com.example.springjpamanytomany.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstNameContaining(String firstName);
}
