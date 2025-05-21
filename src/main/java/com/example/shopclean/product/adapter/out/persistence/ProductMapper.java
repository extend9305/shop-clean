package com.example.shopclean.product.adapter.out.persistence;

import com.example.shopclean.product.domain.Product;
import com.example.shopclean.product.domain.ProductId;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    Product mapToDomainEntity (ProductJpaEntity product){
        return Product.withId(
                new ProductId(product.getId()),product.getName(),product.getPrice(),product.getDetail()
        );
    }
}
