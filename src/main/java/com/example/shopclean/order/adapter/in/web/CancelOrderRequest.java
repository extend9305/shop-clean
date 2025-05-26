package com.example.shopclean.order.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelOrderRequest {
    private final String memberId;
    private final Long version;
}
