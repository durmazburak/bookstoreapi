package com.example.bookstoreapi.convert;

import com.example.bookstoreapi.model.entity.Order;
import com.example.bookstoreapi.model.response.OrderListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderListConverter {
    private final OrderConverter orderConverter;

    public OrderListConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }

    public OrderListResponse convert(List<Order> orderList) {
        OrderListResponse orderListResponse = new OrderListResponse();

        orderListResponse.setOrderResponseList(orderList
                .stream()
                .map(orderConverter::convert).collect(Collectors.toList()));

        return orderListResponse;
    }
}
