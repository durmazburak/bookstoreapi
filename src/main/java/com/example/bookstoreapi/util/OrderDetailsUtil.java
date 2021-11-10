package com.example.bookstoreapi.util;

import com.example.bookstoreapi.model.entity.Book;
import com.example.bookstoreapi.model.entity.OrderDetail;
import com.example.bookstoreapi.model.request.OrderDetailRequest;
import com.example.bookstoreapi.model.request.OrderRequest;
import com.example.bookstoreapi.service.BookService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailsUtil {
    private final BookService bookService;

    public OrderDetailsUtil(BookService bookService) {
        this.bookService = bookService;
    }

    public List<OrderDetail> getOrderDetails(OrderRequest orderRequest) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailRequest orderDetailRequest : orderRequest.getOrderDetails()) {
            Book book = bookService.findById(orderDetailRequest.getBookId());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBookId(orderDetailRequest.getBookId());
            orderDetail.setCount(orderDetailRequest.getQty());
            orderDetail.setPrice(book.getPrice());
            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }
}
