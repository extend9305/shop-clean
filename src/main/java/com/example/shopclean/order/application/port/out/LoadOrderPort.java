package com.example.shopclean.order.application.port.out;

import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderNo;

public interface LoadOrderPort {
    public Order loadOrderByOrderNo(OrderNo orderNo);
}
