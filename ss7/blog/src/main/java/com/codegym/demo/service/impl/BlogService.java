package com.codegym.demo.service.impl;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @Override
    public List<Blog> getAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getStudentById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }
}
