package com.example.bookstoreapi.model.response;

import lombok.Data;

import java.util.List;
@Data
public class OrderListResponse {
    private List<OrderResponse> orderResponseList;
}
