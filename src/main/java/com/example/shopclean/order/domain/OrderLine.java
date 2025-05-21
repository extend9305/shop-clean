package com.example.shopclean.order.domain;

public class OrderLine {
    private String productId;

    protected OrderLine() {}

    public OrderLine(String productId) {
        this.productId = productId;
    }
}
