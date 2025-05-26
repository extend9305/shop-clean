package com.example.shopclean.order.event;

import com.example.shopclean.common.event.Event;

public class OrderCanceledEvent extends Event {
    private String orderNumber;

    public OrderCanceledEvent(String orderNumber) {
        super();
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
