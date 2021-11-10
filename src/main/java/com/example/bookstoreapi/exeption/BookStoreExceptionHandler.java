package com.example.bookstoreapi.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class BookStoreExceptionHandler {
    private static final Logger STOCK_LOG = LoggerFactory.getLogger(InsufficientStockException.class);
    private static final Logger NOT_FOUND_LOG = LoggerFactory.getLogger(NotFoundException.class);

    @ExceptionHandler(InsufficientStockException.class)
    protected ResponseEntity<Object> handleInsufficientStockException(InsufficientStockException ex) {

        STOCK_LOG.warn("Handling InsufficientStockException [{}]", ex.getMessage());
        Map<String, String> map = new HashMap<>();
        map.put("error", "InsufficientStockException");
        map.put("message", ex.getMessage());
        return new ResponseEntity<>(
                map, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {

        NOT_FOUND_LOG.warn("Handling NotFoundException [{}]", ex.getMessage());
        Map<String, String> map = new HashMap<>();
        map.put("error", "NotFoundException");
        map.put("message", ex.getMessage());
        return new ResponseEntity<>(
                map, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
