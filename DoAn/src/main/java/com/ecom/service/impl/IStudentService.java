package com.ecom.service.impl;

import com.ecom.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> searchStudentsByName(String name);
}
