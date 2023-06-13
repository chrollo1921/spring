package com.example.springjpamanytomany.repository;

import com.example.springjpamanytomany.repository.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public List<Course> findByFeeLessThan(double fee);
}
