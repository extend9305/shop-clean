package com.example.shopclean.order.application.port.in;

import com.example.shopclean.member.domain.MemberId;
import com.example.shopclean.order.domain.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PlaceOrderCommand {
    private List<OrderProduct> orderProducts;
    private MemberId ordererMemberId;
    private ShippingInfo shippingInfo;
}
