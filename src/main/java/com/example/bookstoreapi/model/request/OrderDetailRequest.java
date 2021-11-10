package com.example.bookstoreapi.model.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderDetailRequest {
    @NotNull(message = "Please Book Id is required")
    private int bookId;

    @NotNull(message = "Please Quantity field is required")
    @Min(value = 1, message = "Quantity of book can not be lower than one")
    private int qty;
}
