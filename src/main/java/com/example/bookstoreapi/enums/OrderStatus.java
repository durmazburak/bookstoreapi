package com.example.bookstoreapi.enums;

public enum OrderStatus {
    ORDERED(0),
    CANCELED(-1),
    COMPLETED(1);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
