package com.example.book_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    private String title;
    private Integer price;
    private Integer quantity;
    @OneToMany (mappedBy = "book", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<BorrowedBook> bookSet;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<BorrowedBook> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<BorrowedBook> bookSet) {
        this.bookSet = bookSet;
    }
}
