package com.example.shopclean.product.domain;

import com.example.shopclean.common.model.Money;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Getter
    private ProductId id;

    @Getter
    private String name;

    @Getter
    private Money price;
    @Getter
    private String detail;

    public static Product withId(ProductId id, String name, Money price, String detail) {
        return new Product(id, name, price, detail);
    }
}
