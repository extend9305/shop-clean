package com.example.shopclean.order.application.port.in;

import com.example.shopclean.order.domain.OrderNo;
import lombok.Value;

@Value
public class LoadOrderCommand {
    private OrderNo orderNo;
}
