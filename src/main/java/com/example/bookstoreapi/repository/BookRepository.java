package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    List<Book> findAllBy();

    Book findById(@Param("bookId") int bookId);

    void deleteById(@Param("bookId") int bookId);
}
