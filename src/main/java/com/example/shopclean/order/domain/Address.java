package com.example.shopclean.order.domain;

import lombok.Getter;

@Getter
public class Address {
    private String zipCode;

    private String address1;

    private String address2;

    protected Address() {}

    public Address(String zipCode, String address1, String address2) {
        this.zipCode = zipCode;
        this.address1 = address1;
        this.address2 = address2;
    }
}
