package com.example.shopclean.order.domain;

import lombok.Getter;

@Getter
public class Receiver {
    private String name;

    private String phone;

    protected Receiver() {}

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
