package com.example.shopclean.catalog.adapter.in.web;

import com.example.shopclean.catalog.application.service.category.LoadCategoryService;
import com.example.shopclean.catalog.domain.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LoadCategoryController {
    private final LoadCategoryService loadCategoryService;

    @GetMapping("/categories")
    public List<LoadCategoryResponse> categories() {
        List<Category> categories = loadCategoryService.findAll();
        return categories.stream()
                .map(category -> new LoadCategoryResponse(
                        category.getId().getValue()
                        , category.getName())
                ).collect(Collectors.toList());
    }
}
