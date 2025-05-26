package com.example.shopclean.order.application.port.out;

public interface NotificationPort {
    public void sendOrderCanceledConfirmation(String orderId);
}
