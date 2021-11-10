package com.example.bookstoreapi.convert;

import com.example.bookstoreapi.model.entity.OrderDetail;
import com.example.bookstoreapi.model.response.OrderDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter {

    public OrderDetailResponse convert(OrderDetail orderDetail) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();

        orderDetailResponse.setBookId(orderDetail.getBookId());
        orderDetailResponse.setCount(orderDetail.getCount());
        orderDetailResponse.setPrice(orderDetail.getPrice());

        return orderDetailResponse;
    }
}
