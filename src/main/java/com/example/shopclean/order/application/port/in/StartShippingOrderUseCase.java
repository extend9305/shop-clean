package com.example.shopclean.order.application.port.in;

import com.example.shopclean.order.domain.Order;

public interface StartShippingOrderUseCase {
    public void startShipping(StartShippingOrderCommand command);
}
