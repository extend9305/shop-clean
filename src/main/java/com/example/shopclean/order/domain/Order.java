package com.example.shopclean.order.domain;

import com.example.shopclean.common.model.Money;
import com.example.shopclean.order.domain.exception.AlreadyShippedException;
import com.example.shopclean.order.domain.exception.OrderAlreadyCanceledException;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    @Getter
    private OrderNo orderNo;

    @Getter
    private Long version;

    @Getter
    private Orderer orderer;

    @Getter
    private ShippingInfo shippingInfo;

    @Getter
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Getter
    private Money totalAmounts;

    @Getter
    List<OrderLine> orderLines;

    @Getter
    private LocalDateTime orderDate;

    protected Order() {}

    private Order(OrderNo orderNo,Long version ,Orderer orderer, ShippingInfo shippingInfo, OrderState state, List<OrderLine> orderLines) {
        this.orderNo = orderNo;
        this.version = version;
        this.orderer = orderer;
        this.shippingInfo = shippingInfo;
        this.state = state;
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    public static Order withId(OrderNo orderNo,Long version, Orderer orderer, ShippingInfo shippingInfo, OrderState state,  List<OrderLine> orderLines) {
        return new Order(orderNo,version,orderer,shippingInfo,state,orderLines);
    }
    public static Order withoutId(Orderer orderer, ShippingInfo shippingInfo, OrderState state,  List<OrderLine> orderLines) {
        return new Order(OrderNo.nextOrderNo(),null,orderer,shippingInfo,state,orderLines);
    }

    public void cancel(){
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void calculateTotalAmounts(){
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(order -> order.getAmount().getValue()).sum());
    }

    public boolean isNotYetShipped() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }

    public boolean matchVersion(long version) {
        return this.version == version;
    }

    public void startShipping(){
        verifyShippableState();
        this.state = OrderState.SHIPPED;
    }

    private void verifyShippableState() {
        verifyNotYetShipped();
        verifyNotCanceled();
    }

    private void verifyNotYetShipped() {
        if (!isNotYetShipped())
            throw new AlreadyShippedException();
    }

    private void verifyNotCanceled() {
        if (state == OrderState.CANCELED) {
            throw new OrderAlreadyCanceledException();
        }
    }

}
