package com.example.book_app.service;

import com.example.book_app.dto.BorrowedBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookService extends JpaRepository<BorrowedBookDTO, Integer> {
}
