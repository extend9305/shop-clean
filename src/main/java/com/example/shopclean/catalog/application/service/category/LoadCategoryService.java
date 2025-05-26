package com.example.shopclean.catalog.application.service.category;

import com.example.shopclean.catalog.application.port.in.category.LoadCategoryUseCase;
import com.example.shopclean.catalog.application.port.out.category.LoadCategoryPort;
import com.example.shopclean.catalog.domain.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadCategoryService implements LoadCategoryUseCase {
    private final LoadCategoryPort loadCategoryPort;
    @Override
    public List<Category> findAll() {
        return loadCategoryPort.findAll();
    }
}
