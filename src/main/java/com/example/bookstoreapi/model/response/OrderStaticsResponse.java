package com.example.bookstoreapi.model.response;

import lombok.Data;

@Data
public class OrderStaticsResponse {

    int totalOrderCount;
    int totalBookCount;
    Double totalPurchasedAmount;
}
