package com.example.shopclean.catalog.adapter.out.persistence.product;

import com.example.shopclean.catalog.domain.product.Product;
import com.example.shopclean.catalog.domain.product.ProductId;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    Product mapToDomainEntity (ProductJpaEntity product){
        return Product.withId(
                new ProductId(product.getId()),product.getName(),product.getPrice(),product.getDetail()
        );
    }
}
