package com.example.bookstoreapi.model.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;


@Document(collection = "book")
public class Book {

    @Id
    private int id;

    /**
     * Book Name
     */
    private String name;

    /**
     * Book Description
     */
    private String description;

    /**
     * Book Author
     */
    private String author;

    /**
     * Book Price
     */
    private double price;

    /**
     * Stock value
     */
    private int stock;

    @Transient
    public static final String SEQUENCE_NAME = "book_sequence";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
