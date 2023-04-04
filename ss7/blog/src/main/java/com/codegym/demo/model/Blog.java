package com.codegym.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String date;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String date, String content, String status, Category category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.content = content;
        this.status = status;
        this.category = category;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", category=" + category +
                '}';
    }
}
