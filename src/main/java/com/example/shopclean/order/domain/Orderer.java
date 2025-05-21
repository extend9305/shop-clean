package com.example.shopclean.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Orderer {
    private String memberId;
    private String name;

    protected Orderer() {}

    public Orderer(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

}
