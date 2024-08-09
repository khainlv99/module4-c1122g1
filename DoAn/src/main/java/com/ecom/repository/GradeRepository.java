package com.ecom.repository;

import com.ecom.model.Grade;
import com.ecom.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Grade getStudentById(Long id);
}