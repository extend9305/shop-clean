package com.example.shopclean.order.application.service;

import com.example.shopclean.common.model.Money;
import com.example.shopclean.member.application.port.out.LoadMemberPort;
import com.example.shopclean.member.domain.Member;
import com.example.shopclean.order.application.port.in.PlaceOrderCommand;
import com.example.shopclean.order.application.port.in.PlaceOrderUseCase;
import com.example.shopclean.order.application.port.out.PlaceOrderPort;
import com.example.shopclean.order.domain.Order;
import com.example.shopclean.order.domain.OrderLine;
import com.example.shopclean.order.domain.OrderNo;
import com.example.shopclean.order.domain.OrderState;
import com.example.shopclean.order.domain.Orderer;
import com.example.shopclean.product.application.port.out.LoadProductPort;
import com.example.shopclean.product.domain.Product;
import com.example.shopclean.product.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceOrderService implements PlaceOrderUseCase {
    private final LoadMemberPort loadMemberPort;
    private final PlaceOrderPort placeOrderPort;
    private final LoadProductPort loadProductPort;

    @Override
    @Transactional
    public OrderNo placeOrder(PlaceOrderCommand placeOrderCommand) {
        //여기서 멤버 조회, 오더 조회 해서 생성 어답터 시도.
        //validation

        //product find
        List<OrderLine> orderLines = new ArrayList<>();
        placeOrderCommand.getOrderProducts().forEach(op -> {
            Product product = loadProductPort.loadProduct(new ProductId(op.getProductId()));
            orderLines.add(new OrderLine(product.getId().getId(), new Money(product.getPrice().getValue()),op.getQuantity()));
        });

        Member member = loadMemberPort.loadMember(placeOrderCommand.getOrdererMemberId());

        Order order = Order.withoutId(
                new Orderer(member.getMemberId().getId(), member.getName()),
                placeOrderCommand.getShippingInfo(),
                OrderState.PAYMENT_WAITING,
                orderLines
        );
        //create order
        placeOrderPort.placeOrder(order);

        return null;
    }


}
