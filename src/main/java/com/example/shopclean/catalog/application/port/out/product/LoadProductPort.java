package com.example.shopclean.catalog.application.port.out.product;

import com.example.shopclean.catalog.domain.product.Product;
import com.example.shopclean.catalog.domain.product.ProductId;

public interface LoadProductPort {
    Product loadProduct(ProductId productId);
}
