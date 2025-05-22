package com.example.shopclean.order.adapter.out.persistence;

import com.example.shopclean.order.application.port.out.CancelOrderPort;
import com.example.shopclean.order.application.port.out.LoadOrderPort;
import com.example.shopclean.order.application.port.out.PlaceOrderPort;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements LoadOrderPort, PlaceOrderPort , CancelOrderPort {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order loadOrderByOrderNo(OrderNo orderNo) {
        Optional<OrderJpaEntity> order = orderRepository.findById(orderNo.getNumber());
        return order.map(orderMapper::mapToDomainEntity).orElse(null);
    }

    @Override
    public OrderNo placeOrder(Order order) {
        OrderJpaEntity orderJpaEntity = orderMapper.mapToJpaEntity(order);
        OrderJpaEntity saveOrder = orderRepository.save(orderJpaEntity);
        return new OrderNo(saveOrder.getNumber());
    }

    @Override
    public void cancel(Order order) {
        OrderJpaEntity orderJpaEntity = orderMapper.mapToJpaEntity(order);
        orderRepository.save(orderJpaEntity);
    }
}
