package com.example.book_borrowing_app.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class QuantityLowerThanZeroException {
    @ExceptionHandler(com.example.book_borrowing_app.Exception.QuantityLowerThanZeroException.class)
    public String handleQuantityLowerThanZeroException () {
        return "/quantity_error";
    }
}
