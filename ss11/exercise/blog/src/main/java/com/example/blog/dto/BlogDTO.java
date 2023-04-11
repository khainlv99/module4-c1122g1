package com.example.blog.dto;

import com.example.blog.model.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class BlogDTO {
    private Integer id;
    private String authorName;
    private String title;
    private CategoryDTO categoryDTO;

    public BlogDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
