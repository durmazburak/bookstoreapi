package com.example.bookstoreapi.model.response;

import com.example.bookstoreapi.model.response.OrderDetailResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class OrderResponse {

    private int orderId;
    private int customerId;
    private double totalPrice;
    private LocalDate orderDate;
    private String orderStatus;
    private List<OrderDetailResponse> orderDetails;
}
