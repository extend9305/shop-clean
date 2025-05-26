package com.example.shopclean.order.adapter.out.infra;

import com.example.shopclean.order.application.port.out.NotificationPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationAdapter implements NotificationPort {
    @Override
    public void sendOrderCanceledConfirmation(String orderId) {
        log.info("Order canceled confirmation for {}", orderId);
    }
}
