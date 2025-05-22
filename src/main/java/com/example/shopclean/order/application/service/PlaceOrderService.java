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

        //Todo 바운디드 컨텍스트별로 프로젝트가 쪼개 진다면 Product는 order pakage 에 있어야 한다. 그래서 추후 변경 예정

        // 주문 상품 조회 및 주문 내역 생성
        List<OrderLine> orderLines = new ArrayList<>();
        placeOrderCommand.getOrderProducts().forEach(op -> {
            Product product = loadProductPort.loadProduct(new ProductId(op.getProductId()));
            orderLines.add(OrderLine.withId(product.getId().getId(), new Money(product.getPrice().getValue()),op.getQuantity()));
        });

        // 주문자 정보 조회
        Member member = loadMemberPort.loadMember(placeOrderCommand.getOrdererMemberId());

        Order order = Order.withoutId(
                Orderer.of(member.getMemberId().getId(), member.getName()),
                placeOrderCommand.getShippingInfo(),
                OrderState.PAYMENT_WAITING,
                orderLines
        );
        // 주문 처리
        placeOrderPort.placeOrder(order);

        return order.getOrderNo();
    }


}
