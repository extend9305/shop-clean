package com.example.shopclean.order.adapter.out.persistence;

import com.example.shopclean.order.domain.Money;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderLineJpaEntity {
    @Column(name = "product_id")
    private String productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;
}
