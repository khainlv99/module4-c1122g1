package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);

    Blog getStudentById(int id);
    void delete(Integer id);
}
