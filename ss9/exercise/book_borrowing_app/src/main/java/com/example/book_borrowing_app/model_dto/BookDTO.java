package com.example.book_borrowing_app.model_dto;

import com.example.book_borrowing_app.Exception.WrongCodeException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;

public class BookDTO {
    private Integer id;
    private String title;
    private Integer price;
    @Min(value = 0, message = "{quantity.min}")
    private Integer quantity;
    private String borrowCode;

    public BookDTO() {
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

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public String borrow () {
        this.quantity = quantity - 1;
        this.borrowCode = (int)Math.floor(Math.random() * (99999 - 10000 + 1) + 10000) + "";
        return this.borrowCode;
    }

    public void giveBack (String borrowCode) throws WrongCodeException {
        if (this.borrowCode.equals(borrowCode)) {
            this.quantity = quantity + 1;
        }
        else {
            throw new WrongCodeException();
        }
    }
}
