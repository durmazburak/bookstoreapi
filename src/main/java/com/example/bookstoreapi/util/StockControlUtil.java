package com.example.bookstoreapi.util;

import com.example.bookstoreapi.model.entity.Book;
import com.example.bookstoreapi.exeption.InsufficientStockException;

public class StockControlUtil {
    public static void updateStock(Book book, int quantity) {
        book.setStock(checkAndReturnStock(book.getStock(), quantity));
    }

    private static int checkAndReturnStock(int bookStock, int quantity) {
        if (bookStock >= quantity) {
            return bookStock - quantity;
        }
        throw new InsufficientStockException("Insufficient stock");
    }
}
