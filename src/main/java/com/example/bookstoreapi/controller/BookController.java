package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.entity.Book;
import com.example.bookstoreapi.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, path = "/book/")
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @Autowired
    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(value = "/getBook")
    public List<Book> getAllBook(){
        return bookService.findAllBy();
    }

    @GetMapping(value = "/getBook/{bookId}")
    public Book getBookById(@PathVariable int bookId){
        return bookService.findById(bookId);
    }

    @DeleteMapping("deleteBook/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
        LOG.info("Delete is successfully.");
    }
}
