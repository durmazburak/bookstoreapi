package com.example.bookstoreapi.model.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @NotNull(message = "Customer Id is required")
    private int customerId;

    private List<OrderDetailRequest> orderDetails;
}
