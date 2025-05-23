package com.example.shopclean.order.adapter.in.web;

import com.example.shopclean.order.application.port.in.StartShippingOrderCommand;
import com.example.shopclean.order.application.port.in.StartShippingOrderUseCase;
import com.example.shopclean.order.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StartShippingOrderController {
    private final StartShippingOrderUseCase startShippingOrderUseCase;

    @PostMapping("/orders/{orderNo}/shipping")
    public void shipping(@PathVariable("orderNo") String orderNo, @RequestBody StartShippingOrderRequest request) {
        startShippingOrderUseCase.startShipping(new StartShippingOrderCommand(new OrderNo(orderNo),request.getVersion()));
    }
}
