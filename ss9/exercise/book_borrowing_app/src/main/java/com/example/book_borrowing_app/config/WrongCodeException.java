package com.example.book_borrowing_app.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WrongCodeException {
    @ExceptionHandler(com.example.book_borrowing_app.Exception.WrongCodeException.class)
    public String handleWrongCodeException () {
        return "/error";
    }
}
