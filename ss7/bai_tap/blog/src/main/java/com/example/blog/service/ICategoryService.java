package com.example.blog.service;

import com.example.blog.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(String name, Pageable pageable);
    void createCategory (Category category);
    List<Category> listAll();
}
