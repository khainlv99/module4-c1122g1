package com.example.book_borrowing_app.service.impl;

import com.example.book_borrowing_app.model.Book;
import com.example.book_borrowing_app.model_dto.BookDTO;
import com.example.book_borrowing_app.repository.IBookRepository;
import com.example.book_borrowing_app.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<BookDTO> findAllBook() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        BookDTO bookDTO;
        for (Book book : bookList) {
            bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO findById(int id) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(Objects.requireNonNull(bookRepository.findById(id).orElse(null)), bookDTO);
        return bookDTO;
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
