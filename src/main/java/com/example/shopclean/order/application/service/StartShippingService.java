package com.example.shopclean.order.application.service;

import com.example.shopclean.common.exception.VersionConflictException;
import com.example.shopclean.order.application.port.in.StartShippingOrderCommand;
import com.example.shopclean.order.application.port.in.StartShippingOrderUseCase;
import com.example.shopclean.order.application.port.out.LoadOrderPort;
import com.example.shopclean.order.application.port.out.PlaceOrderPort;
import com.example.shopclean.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StartShippingService implements StartShippingOrderUseCase {
    private final LoadOrderPort loadOrderPort;
    private final PlaceOrderPort placeOrderPort;

    @Override
    @Transactional
    public void startShipping(StartShippingOrderCommand command) {
        Order order = loadOrderPort.loadOrderByOrderNo(command.getOrderNo());

        if(order.matchVersion(command.getVersion())) {
            throw new VersionConflictException();
        }
        order.startShipping();
        placeOrderPort.placeOrder(order);
    }
}
