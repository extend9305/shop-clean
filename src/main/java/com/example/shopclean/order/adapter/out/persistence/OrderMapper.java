package com.example.shopclean.order.adapter.out.persistence;

import com.example.shopclean.order.domain.Address;
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
                Orderer.of(order.getOrdererId(), order.getOrdererName()),
                new ShippingInfo(
                        new Address(order.getShippingZipCode(),order.getShippingAddress1(),order.getShippingAddress2()),
                        order.getShippingMessage(),
                        new Receiver(order.getReceiverName(),order.getReceiverPhone())
                ),
                OrderState.valueOf(order.getState()),
                order.getOrderLines().stream()
                        .map(o -> OrderLine.withId(o.getProductId(),o.getPrice(),o.getQuantity()))
                        .collect(Collectors.toList())
            );
    }

    OrderJpaEntity mapToJpaEntity(Order order){
        return new OrderJpaEntity(
                    order.getOrderNo().getNumber(),
                    order.getVersion(),
                    order.getOrderer().getMemberId(),
                    order.getOrderer().getName(),
                    order.getOrderLines().stream()
                            .map(product -> new OrderLineJpaEntity(
                                    product.getProductId(),
                                    product.getPrice(),
                                    product.getQuantity(),
                                    product.getAmount())
                            )
                            .collect(Collectors.toList()),
                    order.getTotalAmounts(),
                    order.getShippingInfo().getAddress().getZipCode(),
                    order.getShippingInfo().getAddress().getAddress1(),
                    order.getShippingInfo().getAddress().getAddress2(),
                    order.getShippingInfo().getMessage(),
                    order.getShippingInfo().getReceiver().getName(),
                    order.getShippingInfo().getReceiver().getPhone(),
                    order.getState().name(),
                    order.getOrderDate()
                );
    }
}
