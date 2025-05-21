package com.example.shopclean.order.application.port.in;

import com.example.shopclean.order.domain.OrderNo;
import org.springframework.transaction.annotation.Transactional;

public interface PlaceOrderUseCase {
    @Transactional
    OrderNo placeOrder(PlaceOrderCommand placeOrderCommand);
}
