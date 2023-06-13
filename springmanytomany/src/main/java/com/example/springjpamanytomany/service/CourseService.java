package com.example.springjpamanytomany.service;

import com.example.springjpamanytomany.repository.CourseRepository;
import com.example.springjpamanytomany.repository.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public List<Course> getCourseByFee(double fee){
        return courseRepository.findByFeeLessThan(fee);
    }
}
