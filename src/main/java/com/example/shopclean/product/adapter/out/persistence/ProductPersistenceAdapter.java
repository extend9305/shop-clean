package com.example.shopclean.product.adapter.out.persistence;

import com.example.shopclean.product.application.port.out.LoadProductPort;
import com.example.shopclean.product.domain.Product;
import com.example.shopclean.product.domain.ProductId;
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
