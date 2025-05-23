package com.example.shopclean.catalog.adapter.out.persistence.category;

import com.example.shopclean.catalog.application.port.out.category.LoadCategoryPort;
import com.example.shopclean.catalog.domain.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements LoadCategoryPort {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        List<CategoryJpaEntity> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
