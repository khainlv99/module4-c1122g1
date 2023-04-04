package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
}
