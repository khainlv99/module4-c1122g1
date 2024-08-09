package com.ecom.repository;

import com.ecom.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentById(Long id);
    List<Student> searchStudentsByName(String name);
    List<Student> findByNameContaining(String name);
}
