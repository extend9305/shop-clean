package com.example.shopclean.order.adapter.in.web;

import com.example.shopclean.order.application.port.in.LoadOrderCommand;
import com.example.shopclean.order.application.port.in.LoadOrderUseCase;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoadOrderController {
    private final LoadOrderUseCase loadOrderUseCase;

    @GetMapping("/orders/{orderNo}")
    LoadOrderResponse loadMember(@PathVariable String orderNo) {

        Order order = loadOrderUseCase.loadOrder(new LoadOrderCommand(new OrderNo(orderNo)));
        return new LoadOrderResponse(order.getOrderNo().getNumber(),order.getTotalAmounts().getValue());
    }
}
