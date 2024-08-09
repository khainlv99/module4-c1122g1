package com.ecom.service;

import com.ecom.model.Grade;
import com.ecom.repository.GradeRepository;
import com.ecom.service.impl.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService implements IGradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Grade getGradeById(Long id) {
        return gradeRepository.getStudentById(id);
    }
}
