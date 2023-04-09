package com.example.book_app.service;

import com.example.book_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookService extends JpaRepository<Book, Integer> {
}
