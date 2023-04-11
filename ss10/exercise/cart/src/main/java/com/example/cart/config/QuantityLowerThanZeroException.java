package com.example.cart.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


    @ControllerAdvice
    public class QuantityLowerThanZeroException {
        @ExceptionHandler(com.example.cart.exception.QuantityLowerThanZeroException.class)
        public String handleQuantityLowerThanZeroException () {
            return "/quantity_error";
        }
    }

