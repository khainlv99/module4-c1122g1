package com.example.blog.service.impl;

import com.example.blog.dto.BlogDTO;
import com.example.blog.dto.CategoryDTO;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public void setValueOfBlogDTOSet(Category category, CategoryDTO categoryDTO) {
        Set<Blog> blogSet = category.getBlogSet();
        Set<BlogDTO> blogDTOS = new HashSet<>();
        BlogDTO blogDTO;
        for (Blog blog : blogSet) {
            blogDTO = new BlogDTO();
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTOS.add(blogDTO);
        }
        BeanUtils.copyProperties(category, categoryDTO);
        categoryDTO.setBlogDTOSet(blogDTOS);
    }
    @Override
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        CategoryDTO categoryDTO;
        for (Category category : categoryPage) {
            categoryDTO = new CategoryDTO();
            setValueOfBlogDTOSet(category, categoryDTO);
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return new PageImpl<>(categoryDTOList, pageable, categoryPage.getTotalElements());
    }

    @Override
    public List<CategoryDTO> findAllList() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        CategoryDTO categoryDTO;
        for (Category category : categoryList) {
            categoryDTO = new CategoryDTO();
            setValueOfBlogDTOSet(category, categoryDTO);
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public CategoryDTO findById(int id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        Category category = categoryRepository.findById(id).get();
        setValueOfBlogDTOSet(category, categoryDTO);
        return categoryDTO;
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }
}
