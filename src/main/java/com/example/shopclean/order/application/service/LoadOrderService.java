package com.example.shopclean.order.application.service;

import com.example.shopclean.order.application.port.in.LoadOrderCommand;
import com.example.shopclean.order.application.port.in.LoadOrderUseCase;
import com.example.shopclean.order.application.port.out.LoadOrderPort;
import com.example.shopclean.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadOrderService implements LoadOrderUseCase {
    private final LoadOrderPort loadOrderPort;
    @Override
    public Order loadOrder(LoadOrderCommand loadOrderCommand) {
        return loadOrderPort.loadOrderByOrderNo(loadOrderCommand.getOrderNo());
    }
}
