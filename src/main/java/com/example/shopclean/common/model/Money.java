package com.example.shopclean.common.model;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }
    public int getValue() {return value;}

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
}
