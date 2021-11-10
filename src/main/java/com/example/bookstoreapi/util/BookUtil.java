package com.example.bookstoreapi.util;

import com.example.bookstoreapi.model.entity.Book;
import com.example.bookstoreapi.model.request.OrderDetailRequest;
import com.example.bookstoreapi.model.request.OrderRequest;
import com.example.bookstoreapi.service.BookService;
import org.springframework.stereotype.Component;

@Component
public class BookUtil {
    private final BookService bookService;

    public BookUtil(BookService bookService) {
        this.bookService = bookService;
    }

    public Double getTotalBookPrice(OrderRequest orderRequest) {
        double totalPrice = 0;
        for (OrderDetailRequest orderDetailRequest : orderRequest.getOrderDetails()) {
            Book book = bookService.findById(orderDetailRequest.getBookId());
            totalPrice += (book.getPrice() * orderDetailRequest.getQty());
        }
        return totalPrice;
    }
}
