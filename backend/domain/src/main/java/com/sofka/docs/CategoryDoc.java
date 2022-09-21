package com.sofka.docs;

import co.com.sofka.domain.generic.Entity;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;

import java.util.HashSet;
import java.util.Set;

public class CategoryDoc extends Entity<CategoryId> {
    private CategoryName categoryName;

    public CategoryDoc(CategoryId entityId, CategoryName categoryName) {
        super(entityId);
        this.categoryName = categoryName;
    }

    public CategoryName categoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }


}
