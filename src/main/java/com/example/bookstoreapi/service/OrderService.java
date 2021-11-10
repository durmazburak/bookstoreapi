package com.example.bookstoreapi.service;

import com.example.bookstoreapi.model.entity.Order;
import com.example.bookstoreapi.model.request.OrderRequest;
import com.example.bookstoreapi.model.response.OrderStaticsResponse;
import com.example.bookstoreapi.enums.OrderStatus;
import com.example.bookstoreapi.repository.OrderRepository;
import com.example.bookstoreapi.util.BookUtil;
import com.example.bookstoreapi.util.OrderDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final BookUtil bookUtil;
    private final OrderDetailsUtil orderDetailsUtil;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService,
                        BookUtil bookUtil, OrderDetailsUtil orderDetailsUtil, SequenceGeneratorService sequenceGeneratorService){
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.bookUtil = bookUtil;
        this.orderDetailsUtil = orderDetailsUtil;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public List<Order> findAllBy(){
        return orderRepository.findAllBy();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order prepareOrder(OrderRequest orderRequest) {
        Order order = new Order();

        if (Objects.nonNull(orderRequest)) {
            order.setId(sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME));
            order.setCustomerId(customerService.findByCustomerId(orderRequest.getCustomerId()).getId());
            if (Objects.nonNull(orderRequest.getOrderDetails())) {
                order.setOrderDetails(orderDetailsUtil.getOrderDetails(orderRequest));
            }
            order.setOrderStatus(OrderStatus.ORDERED.getValue());
            order.setOrderDate(LocalDate.now());
            order.setTotalPrice(bookUtil.getTotalBookPrice(orderRequest));
        }
        return order;
    }

    public List<Order> findOrderByCustomerId(int customerId){
        return orderRepository.findOrderByCustomerId(customerId);
    }

    public OrderStaticsResponse getOrderStatics(int customerId, int month){
        OrderStaticsResponse response = new OrderStaticsResponse();
        List<Order> orderList =  orderRepository.findOrderByCustomerId(customerId);
        List<Order> newList = new ArrayList<>();
        int orderMoth;
        double totalPurchasedAmount = 0;
        int bookCount = 0;

        if (Objects.nonNull(orderList)) {
            for (Order order : orderList) {
                orderMoth = order.getOrderDate().getMonthValue();
                if (orderMoth == month) {
                    newList.add(order);
                }
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            totalPurchasedAmount += newList.get(i).getTotalPrice();
            bookCount += newList.get(i).getOrderDetails().get(i).getCount();
        }

        response.setTotalOrderCount(newList.size());
        response.setTotalPurchasedAmount(totalPurchasedAmount);
        response.setTotalBookCount(bookCount);

        return response;
    }
}
