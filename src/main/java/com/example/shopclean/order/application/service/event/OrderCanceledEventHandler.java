package com.example.shopclean.order.application.service.event;

import com.example.shopclean.order.application.port.out.NotificationPort;
import com.example.shopclean.order.event.OrderCanceledEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class OrderCanceledEventHandler {
    private final NotificationPort notificationPort;

    @Async
    @TransactionalEventListener(
            classes = OrderCanceledEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void handle(OrderCanceledEvent event) {
        notificationPort.sendOrderCanceledConfirmation(event.getOrderNumber());
    }
}
