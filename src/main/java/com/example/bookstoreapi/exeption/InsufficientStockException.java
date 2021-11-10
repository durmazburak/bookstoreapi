package com.example.bookstoreapi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientStockException  extends RuntimeException{
    private static final long serialVersionUID = -7842251223561640341L;
    public InsufficientStockException(String message) {
        super(message);
    }
}
