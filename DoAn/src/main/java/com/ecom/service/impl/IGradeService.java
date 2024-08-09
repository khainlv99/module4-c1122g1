package com.ecom.service.impl;

import com.ecom.model.Grade;
import com.ecom.model.Student;

import java.util.List;

public interface IGradeService {
    List<Grade> getAllGrades();
    void saveGrade(Grade grade);
    void deleteGrade(Long id);
    Grade getGradeById(Long id);  // Add this method if needed for editing
}
