package com.example.shopclean.catalog.adapter.out.persistence.product;

import com.example.shopclean.catalog.application.port.out.product.LoadProductPort;
import com.example.shopclean.catalog.domain.product.Product;
import com.example.shopclean.catalog.domain.product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements LoadProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product loadProduct(ProductId productId) {
        Optional<ProductJpaEntity> product = productRepository.findById(productId.getId());
        return product.map(productMapper::mapToDomainEntity).orElse(null);
    }

}
