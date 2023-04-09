package com.example.book_borrowing_app.service;

import com.example.book_borrowing_app.model.Book;
import com.example.book_borrowing_app.model_dto.BookDTO;

import java.util.List;

public interface IBookService {
    List<BookDTO> findAllBook();
    BookDTO findById(int id);
    void updateBook (Book book);
}
