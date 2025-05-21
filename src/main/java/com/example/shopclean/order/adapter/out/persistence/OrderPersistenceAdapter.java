package com.example.shopclean.order.adapter.out.persistence;

import com.example.shopclean.order.application.port.out.LoadOrderPort;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderPersistenceAdapter implements LoadOrderPort {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order loadOrderByOrderNo(OrderNo orderNo) {
        Optional<OrderJpaEntity> order = orderRepository.findById(orderNo.getNumber());
        if (order.isPresent()) {
            return orderMapper.mapToDomainEntity(order.get());
        }else{
            return null;
        }
    }
}
