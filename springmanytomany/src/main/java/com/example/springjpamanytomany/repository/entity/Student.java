package com.example.springjpamanytomany.repository.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String department;

    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="Students_Courses_Table",
    joinColumns = {
            @JoinColumn(name="student_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name="column_id", referencedColumnName = "id")
    })
    @JsonManagedReference
    private Set<Course> courses;

//    @JsonManagedReference
//    public Set<Course> getCourses() {
//        return courses;
//    }
}
