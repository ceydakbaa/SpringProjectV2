package com.example.ceyda.service;

import com.example.ceyda.entity.Student;

import java.util.List;

public interface StudentService {

    public Student createStudent(Student student);
    public List<Student> getAllStudents();
}
