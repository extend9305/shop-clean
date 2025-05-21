package com.example.shopclean.order.domain;

import lombok.Getter;

@Getter
public class ShippingInfo {
    private Address address;

    private String message;

    private Receiver receiver;

    protected ShippingInfo() {}

    public ShippingInfo(Address address, String message, Receiver receiver) {
        this.address = address;
        this.message = message;
        this.receiver = receiver;
    }
}
