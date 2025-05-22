package com.example.shopclean.order.application.port.out;

import com.example.shopclean.order.application.port.in.PlaceOrderCommand;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderNo;

public interface PlaceOrderPort {
    public OrderNo placeOrder(Order order);
}
