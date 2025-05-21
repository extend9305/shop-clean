package com.example.shopclean.order.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    @Getter
    private OrderNo orderNo;

    @Getter
    private long version;

    @Getter
    private Orderer orderer;

    @Getter
    private ShippingInfo shippingInfo;

    @Getter
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Getter
    private Money totalAmounts;

    @Getter
    List<OrderLine> orderLines;

    @Getter
    private LocalDateTime orderDate;

    protected Order() {}

    private Order(OrderNo orderNo, long version, Orderer orderer, ShippingInfo shippingInfo, OrderState state, Money totalAmounts, List<OrderLine> orderLines, LocalDateTime orderDate) {
        this.orderNo = orderNo;
        this.version = version;
        this.orderer = orderer;
        this.shippingInfo = shippingInfo;
        this.state = state;
        this.totalAmounts = totalAmounts;
        this.orderLines = orderLines;
        this.orderDate = orderDate;
    }

    public static Order withId(OrderNo orderNo, long version, Orderer orderer, ShippingInfo shippingInfo, OrderState state, Money totalAmounts, List<OrderLine> orderLines, LocalDateTime orderDate) {
        return new Order(orderNo,version,orderer,shippingInfo,state,totalAmounts,orderLines,orderDate);
    }
}
