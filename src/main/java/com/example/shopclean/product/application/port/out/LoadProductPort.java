package com.example.shopclean.product.application.port.out;

import com.example.shopclean.product.domain.Product;
import com.example.shopclean.product.domain.ProductId;

public interface LoadProductPort {
    Product loadProduct(ProductId productId);
}
