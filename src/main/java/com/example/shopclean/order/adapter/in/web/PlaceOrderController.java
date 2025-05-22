package com.example.shopclean.order.adapter.in.web;

import com.example.shopclean.order.application.port.in.PlaceOrderCommand;
import com.example.shopclean.order.application.port.in.PlaceOrderUseCase;
import com.example.shopclean.order.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaceOrderController {
    private final PlaceOrderUseCase placeOrderUseCase;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
        PlaceOrderCommand command = new PlaceOrderCommand(
                placeOrderRequest.getOrderProducts(),
                placeOrderRequest.getOrdererMemberId(),
                placeOrderRequest.getShippingInfo()
        );
        OrderNo orderNo = placeOrderUseCase.placeOrder(command);
        return orderNo.getNumber();
    }
}
