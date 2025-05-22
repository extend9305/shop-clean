package com.example.shopclean.order.application.port.out;

import com.example.shopclean.order.domain.Order;

public interface CancelOrderPort {
    void cancel(Order order);
}
