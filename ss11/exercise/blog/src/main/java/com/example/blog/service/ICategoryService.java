package com.example.blog.service;

import com.example.blog.dto.CategoryDTO;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<CategoryDTO> findAll(Pageable pageable);
    List<CategoryDTO> findAllList();
    CategoryDTO findById(int id);
    Category findCategoryByName(String name);
}
