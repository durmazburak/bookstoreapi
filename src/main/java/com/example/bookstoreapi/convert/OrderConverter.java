package com.example.bookstoreapi.convert;

import com.example.bookstoreapi.model.entity.Order;
import com.example.bookstoreapi.model.response.OrderDetailResponse;
import com.example.bookstoreapi.model.response.OrderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    private final OrderDetailConverter orderDetailConverter;
    private final OrderStatusConverter orderStatusConverter;

    public OrderConverter(OrderDetailConverter orderDetailConverter,
                          OrderStatusConverter orderStatusConverter) {
        this.orderDetailConverter = orderDetailConverter;
        this.orderStatusConverter = orderStatusConverter;
    }

    public OrderResponse convert(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getId());
        orderResponse.setCustomerId(order.getCustomerId());
        orderResponse.setTotalPrice(order.getTotalPrice());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setOrderStatus(orderStatusConverter.convert(order.getOrderStatus()).toString());

        List<OrderDetailResponse> orderDetailResponseList = order.getOrderDetails().stream()
                .map(orderDetailConverter::convert)
                .collect(Collectors.toList());

        orderResponse.setOrderDetails(orderDetailResponseList);

        return orderResponse;
    }
}
