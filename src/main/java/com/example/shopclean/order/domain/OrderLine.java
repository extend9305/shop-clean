package com.example.shopclean.order.domain;

import com.example.shopclean.common.model.Money;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLine {
    private String productId;

    private Money price;

    private int quantity;

    private Money amount;

    private OrderLine(String productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amount = calculateAmount();
    }

    private Money calculateAmount() {
        return price.multiply(quantity);
    }

    public static OrderLine withId(String productId, Money price, int quantity) {
        return new OrderLine(productId, price, quantity);
    }
}
