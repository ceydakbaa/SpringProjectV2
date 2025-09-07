package com.example.ceyda.controller;

import com.example.ceyda.entity.Student;
import com.example.ceyda.repository.StudentRepository;
import com.example.ceyda.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/list")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }



}
