package com.example.shopclean.catalog.application.port.out.category;

import com.example.shopclean.catalog.domain.category.Category;

import java.util.List;

public interface LoadCategoryPort {
    List<Category> findAll();
}
