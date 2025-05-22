package com.example.shopclean.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderJpaEntity, String> {

    OrderJpaEntity save(OrderJpaEntity order);


}
