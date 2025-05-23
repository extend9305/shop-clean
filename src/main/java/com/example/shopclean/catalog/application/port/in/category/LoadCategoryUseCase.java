package com.example.shopclean.catalog.application.port.in.category;

import com.example.shopclean.catalog.domain.category.Category;

import java.util.List;

public interface LoadCategoryUseCase {
    List<Category> findAll();
}
