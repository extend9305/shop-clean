package com.example.shopclean.order.adapter.in.web;

import com.example.shopclean.order.application.port.in.CancelOrderCommand;
import com.example.shopclean.order.application.port.in.CancelOrderUseCase;
import com.example.shopclean.order.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CancelOrderController {
    private final CancelOrderUseCase cancelOrderUseCase;

    @PostMapping("/orders/{orderNo}/cancel")
    public void cancel(@PathVariable("orderNo") String orderNo, @RequestBody CancelOrderRequest request) {
        cancelOrderUseCase.cancelOrder(new CancelOrderCommand(new OrderNo(orderNo),request.getMemberId(),request.getVersion()));
    }
}

