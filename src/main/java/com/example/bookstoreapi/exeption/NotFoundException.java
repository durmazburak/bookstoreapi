package com.example.bookstoreapi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends RuntimeException{
    private static final long serialVersionUID = -1352251223561640341L;
    public NotFoundException(String message) {
        super(message);
    }
}
