package com.example.shopclean.catalog.adapter.out.persistence.category;

import com.example.shopclean.catalog.domain.category.Category;
import com.example.shopclean.catalog.domain.category.CategoryId;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    Category mapToDomainEntity(CategoryJpaEntity category) {
        return Category.withId(CategoryId.of(category.getId()), category.getName());
    }
}
