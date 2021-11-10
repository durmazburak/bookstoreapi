package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.convert.OrderListConverter;
import com.example.bookstoreapi.model.entity.Book;
import com.example.bookstoreapi.model.entity.Order;
import com.example.bookstoreapi.model.entity.OrderDetail;
import com.example.bookstoreapi.model.request.OrderRequest;
import com.example.bookstoreapi.model.response.OrderListResponse;
import com.example.bookstoreapi.model.response.OrderStaticsResponse;
import com.example.bookstoreapi.service.BookService;
import com.example.bookstoreapi.service.OrderService;
import com.example.bookstoreapi.util.StockControlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, path = "/order/")
public class OrderController {

    private final OrderService orderService;
    private final BookService bookService;
    private final OrderListConverter orderListConverter;

    @Autowired
    public OrderController (OrderService orderService, BookService bookService, OrderListConverter orderListConverter){
        this.orderService = orderService;
        this.bookService = bookService;
        this.orderListConverter = orderListConverter;
    }

    @PostMapping(value = "/createOrder")
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        Order prepareOrder = orderService.prepareOrder(orderRequest);
        for (OrderDetail orderDetail : prepareOrder.getOrderDetails()) {
            Book book = bookService.findById(orderDetail.getBookId());
            StockControlUtil.updateStock(book, orderDetail.getCount());
            bookService.save(book);
        }

        return orderService.save(prepareOrder);
    }

    @GetMapping(value = "/getCustomerOrder/{customerId}")
    public List<Order> getCustomerOrderById(@PathVariable int customerId){
        return orderService.findOrderByCustomerId(customerId);
    }

    @GetMapping(value = "/getCustomerOrder")
    public OrderListResponse getCustomerOrder(){
        return  orderListConverter.convert(orderService.findAllBy());
    }


    @GetMapping(value = "/getCustomerOrder/{customerId}/{month}")
    public OrderStaticsResponse getOrderStatics(@PathVariable int customerId, @PathVariable int month){
        return orderService.getOrderStatics(customerId, month);
    }
}
