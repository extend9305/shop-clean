package com.example.shopclean.order.domain;

import com.example.shopclean.common.model.Money;
import com.example.shopclean.order.adapter.out.persistence.OrderJpaEntity;
import com.example.shopclean.order.adapter.out.persistence.OrderLineJpaEntity;
import com.example.shopclean.order.adapter.out.persistence.OrderMapper;
import com.example.shopclean.order.adapter.out.persistence.OrderRepository;
import com.example.shopclean.product.domain.ProductId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    @Test
    void save() {

        orderRepository.save(new OrderJpaEntity(
                OrderNo.nextOrderNo().getNumber(),
                null,
                "user1",
                "test",
                List.of(new OrderLineJpaEntity("prod-001", new Money(1000),2, new Money(2000))),
                new Money(20000),
                "12345",
                "addr1",
                "addr2",
                "잘하시길",
                "아무개",
                "010-111-4444",
                OrderState.PAYMENT_WAITING.name(),
                LocalDateTime.now()
        ));
    }
}
