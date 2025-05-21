package com.example.shopclean.order.adapter.out.persistence;

import com.example.shopclean.order.domain.Address;
import com.example.shopclean.order.domain.Money;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderLine;
import com.example.shopclean.order.domain.OrderNo;
import com.example.shopclean.order.domain.OrderState;
import com.example.shopclean.order.domain.Orderer;
import com.example.shopclean.order.domain.Receiver;
import com.example.shopclean.order.domain.ShippingInfo;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {
    Order mapToDomainEntity (OrderJpaEntity order){
        return Order.withId(
                new OrderNo(order.getNumber()),
                order.getVersion(),
                new Orderer(order.getOrdererId(), order.getOrdererName()),
                new ShippingInfo(
                        new Address(order.getShippingZipCode(),order.getShippingAddress1(),order.getShippingAddress2()),
                        order.getShippingMessage(),
                        new Receiver(order.getReceiverName(),order.getReceiverPhone())
                ),
                OrderState.valueOf(order.getState()),
                new Money(order.getTotalAmounts()),
                order.getOrderLines().stream()
                        .map(o -> new OrderLine(o.getProductId()))
                        .collect(Collectors.toList()),
                order.getOrderDate()
            );
    }
}
