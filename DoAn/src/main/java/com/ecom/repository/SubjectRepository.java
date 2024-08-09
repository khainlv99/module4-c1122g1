package com.ecom.repository;

import com.ecom.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject getSubjectById(Long id);
}
