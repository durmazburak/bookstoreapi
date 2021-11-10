package com.example.bookstoreapi.convert;

import com.example.bookstoreapi.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusConverter {
    public OrderStatus convert(int orderStatusValue) {
        switch (orderStatusValue) {
            case 0:
                return OrderStatus.ORDERED;
            case 1:
                return OrderStatus.COMPLETED;
            default:
                return OrderStatus.CANCELED;
        }
    }

    public int convert(OrderStatus orderStatus) {
        return orderStatus.getValue();
    }
}
