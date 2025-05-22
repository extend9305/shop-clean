package com.example.shopclean.order.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Orderer {
    private String memberId;
    private String name;

    public static Orderer of(String memberId, String name) {
        return new Orderer(memberId, name);
    }
}
