package com.example.shopclean.order.adapter.in.web;

import com.example.shopclean.member.domain.MemberId;
import com.example.shopclean.order.application.port.in.OrderProduct;
import com.example.shopclean.order.domain.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PlaceOrderRequest {
    private List<OrderProduct> orderProducts;
    private MemberId ordererMemberId;
    private ShippingInfo shippingInfo;
}
