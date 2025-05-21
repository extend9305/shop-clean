package com.example.shopclean.order.adapter.out.persistence;

import com.example.shopclean.common.jpa.MoneyConverter;
import com.example.shopclean.common.model.Money;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "purchase_order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderJpaEntity {
    @Id
    @Column(name = "order_number")
    private String number;

    @Version
    private Long version;

    @Column(name = "orderer_id")
    private String ordererId;

    @Column(name = "orderer_name")
    private String ordererName;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLineJpaEntity> orderLines;

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    @Column(name = "shipping_zip_code")
    private String shippingZipCode;

    @Column(name = "shipping_addr1")
    private String shippingAddress1;

    @Column(name = "shipping_addr2")
    private String shippingAddress2;

    @Column(name = "shipping_message")
    private String shippingMessage;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_phone")
    private String receiverPhone;

    @Column(name = "state")
    private String state;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

}
