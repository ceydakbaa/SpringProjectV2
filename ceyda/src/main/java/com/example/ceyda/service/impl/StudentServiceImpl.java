package com.example.ceyda.service.impl;

import com.example.ceyda.entity.Student;
import com.example.ceyda.repository.StudentRepository;
import com.example.ceyda.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Transactional //Burada hata mesajları yazacağım rollback yapsın diye
    public Student createStudent(Student student){
        if (studentRepository.existsBySchoolNumber(student.getSchoolNumber())){ //eğer aynı okul numarasına sahip öğrenci varsa diye hata mesajı yazıyoruz.
            throw new IllegalArgumentException("School number already exist");
        }
        Student savedStudent= studentRepository.save(student); //Öğrenciyi kaydediyoruz eğer yoksa
        return savedStudent;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
