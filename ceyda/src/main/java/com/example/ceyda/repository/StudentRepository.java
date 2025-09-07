package com.example.ceyda.repository;

import com.example.ceyda.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsBySchoolNumber(String schoolNumber);
}
