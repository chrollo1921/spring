package com.example.springjpamanytomany.dto;

import com.example.springjpamanytomany.repository.entity.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {

    @JsonManagedReference
    private Student student;
}
