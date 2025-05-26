package com.example.shopclean.catalog.adapter.out.persistence.product;

import com.example.shopclean.common.jpa.MoneyConverter;
import com.example.shopclean.common.model.Money;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductJpaEntity {
    @Id
    @Column(name = "product_id")
    private String id;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

}
