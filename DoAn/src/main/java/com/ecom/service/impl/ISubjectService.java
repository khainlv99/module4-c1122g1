package com.ecom.service.impl;

import com.ecom.model.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> getAllSubjects();
    void saveSubject(Subject subject);
    void deleteSubject(Long id);

    Subject getSubjectById(Long id);
}
