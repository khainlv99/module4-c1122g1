package com.example.blog.repository;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByAuthorNameContaining(String name, Pageable pageable);
}
