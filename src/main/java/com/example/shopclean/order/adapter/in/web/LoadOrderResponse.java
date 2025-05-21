package com.example.shopclean.order.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoadOrderResponse {
    private String orderNumber;
    private int totalAmounts;
}
