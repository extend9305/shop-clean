package com.example.shopclean.order.application.port.in;

import com.example.shopclean.order.domain.OrderNo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
public class CancelOrderCommand {
    private OrderNo orderNo;
    private String memberId;
    private Long version;
}
