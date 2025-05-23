package com.example.shopclean.catalog.domain.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryId {
    private Long value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId categoryId = (CategoryId) o;
        return Objects.equals(value, categoryId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static CategoryId of(Long id) {
        return new CategoryId(id);
    }
}
