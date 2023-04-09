package com.example.book_borrowing_app.repository;

import com.example.book_borrowing_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
