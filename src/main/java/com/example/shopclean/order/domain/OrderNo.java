package com.example.shopclean.order.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class OrderNo implements Serializable {
    private String number;

    protected OrderNo() {}

    public OrderNo(String number) {
        this.number = number;
    }

    public String getNumber() {return number;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderNo orderNo = (OrderNo) o;
        return Objects.equals(number, orderNo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public static OrderNo of(String number) {
        return new OrderNo(number);
    }

    public static OrderNo nextOrderNo() {
        int randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000;
        String number = String.format("%tY%<tm%<td%<tH-%d", new Date(), randomNo);
        return new OrderNo(number);
    }

}
