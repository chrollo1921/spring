package com.example.springjpamanytomany.service;

import com.example.springjpamanytomany.repository.StudentRepository;
import com.example.springjpamanytomany.repository.entity.Student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByFirstName(String firstName){
        return studentRepository.findByFirstNameContaining(firstName);
    }

    public Student saveStudentWithCourse(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElse(null);
    }
}
