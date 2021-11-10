package com.example.bookstoreapi.service;

import com.example.bookstoreapi.model.entity.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBy(){
        return bookRepository.findAllBy();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(int bookId) {
        return bookRepository.findById(bookId);
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
