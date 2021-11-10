package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository repository;

    @Test
    public void findAllBy() {
        List<Book> list = repository.findAllBy();
        Book books = new Book();
        books.setName("Around the World in 80 Days");
        books.setDescription("Travel Fantastic");
        books.setAuthor("Jules Verne");
        books.setStock(12);
        books.setPrice(24.12);
        list.add(books);
        assertNotNull(repository.findAllBy());
    }

    @Test
    public void givenByIdReturnValidId(){
        Book book = repository.findById(1);
        assertThat(book.getId()).isEqualTo(1);
    }

    @Test
    public void deleteById(){
        repository.deleteById(1);
        List<Book> list = repository.findAllBy();
        assertThat(list.size()).isEqualTo(1);
    }
}
