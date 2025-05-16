package com.example.shopclean.member.domain;

public class Password {
    private String value;

    protected Password() {}

    public Password(String value) {
        this.value = value;
    }

    public boolean match(String password) {
        return this.value.equals(password);
    }
}
