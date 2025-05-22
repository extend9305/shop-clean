package com.example.shopclean.order.application.service;

import com.example.shopclean.order.application.port.in.CancelOrderCommand;
import com.example.shopclean.order.application.port.in.CancelOrderUseCase;
import com.example.shopclean.order.application.port.out.CancelOrderPort;
import com.example.shopclean.order.application.port.out.LoadOrderPort;
import com.example.shopclean.order.domain.Order;
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
    public void cancelOrder(CancelOrderCommand cancelOrderCommand) {
        Order order = loadOrderPort.loadOrderByOrderNo(cancelOrderCommand.getOrderNo());

        if(order != null) {
            order.cancel();
            cancelOrderPort.cancel(order);
        }
    }
}
