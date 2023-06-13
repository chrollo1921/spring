package com.example.springjpamanytomany.controller;

import com.example.springjpamanytomany.dto.StudentDTO;
import com.example.springjpamanytomany.repository.entity.Course;
import com.example.springjpamanytomany.repository.entity.Student;
import com.example.springjpamanytomany.service.CourseService;
import com.example.springjpamanytomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentcourse")
public class StudentCourseController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/saveStudent")
    public Student saveStudentWithCourse(@RequestBody StudentDTO student) {
        return studentService.saveStudentWithCourse(student.getStudent());
    }

    @GetMapping
    public List<Student> getStudentsWithCourse(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{firstName}")
    public List<Student> getStudentsWithFirstName(@PathVariable String firstName){
        return studentService.getStudentsByFirstName(firstName);
    }

    @GetMapping("/student/{id}")
    public Student getStudentWithId(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/courses/{fee}")
    public List<Course> getCoursesWithLessFee(@PathVariable long fee){
        return courseService.getCourseByFee(fee);
    }

    @GetMapping("/courses/all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
}
