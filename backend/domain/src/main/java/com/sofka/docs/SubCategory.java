package com.sofka.docs;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.ValueObject;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.SubcategoryId;
import com.sofka.docs.values.SubcategoryName;

public class SubCategory extends Entity<SubcategoryId> {
    private SubcategoryName name;
    private CategoryId categoryId;

    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     */
    public SubCategory(SubcategoryId entityId, SubcategoryName name,CategoryId categoryId) {
        super(entityId);
        this.name = name;
        this.categoryId = categoryId;
    }

    public SubcategoryName getName() {
        return name;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryId categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(SubcategoryName name) {
        this.name = name;
    }
}
