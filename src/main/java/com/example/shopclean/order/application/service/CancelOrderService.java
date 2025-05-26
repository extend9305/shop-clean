package com.example.shopclean.order.application.service;

import com.example.shopclean.common.event.Events;
import com.example.shopclean.common.exception.VersionConflictException;
import com.example.shopclean.order.application.port.in.CancelOrderCommand;
import com.example.shopclean.order.application.port.in.CancelOrderUseCase;
import com.example.shopclean.order.application.port.out.CancelOrderPort;
import com.example.shopclean.order.application.port.out.LoadOrderPort;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.event.OrderCanceledEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CancelOrderService implements CancelOrderUseCase {
    private final LoadOrderPort loadOrderPort;
    private final CancelOrderPort cancelOrderPort;

    @Override
    @Transactional
    public void cancelOrder(CancelOrderCommand command) {
        Order order = loadOrderPort.loadOrderByOrderNo(command.getOrderNo());
        if (!order.matchVersion(command.getVersion())) {
            throw new VersionConflictException();
        }
        order.cancel();
        cancelOrderPort.cancel(order);

        Events.raise(new OrderCanceledEvent(order.getOrderNo().getNumber()));
    }
}
