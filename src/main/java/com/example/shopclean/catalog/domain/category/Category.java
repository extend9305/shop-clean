package com.example.shopclean.catalog.domain.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    private CategoryId id;
    private String name;

    public static Category withId(CategoryId id,String name) {
        return new Category(id, name);
    }
}
