package com.example.shopclean.order.application.port.in;

import com.example.shopclean.order.domain.OrderNo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StartShippingOrderCommand {
    private OrderNo orderNo;
    private long version;
}
