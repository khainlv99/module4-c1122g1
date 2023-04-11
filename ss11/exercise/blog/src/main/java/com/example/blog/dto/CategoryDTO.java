package com.example.blog.dto;

import java.util.Set;

public class CategoryDTO {
    private Integer id;
    private String name;

    private Set<BlogDTO> blogDTOSet;

    public CategoryDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogDTO> getBlogDTOSet() {
        return blogDTOSet;
    }

    public void setBlogDTOSet(Set<BlogDTO> blogDTOSet) {
        this.blogDTOSet = blogDTOSet;
    }
}
