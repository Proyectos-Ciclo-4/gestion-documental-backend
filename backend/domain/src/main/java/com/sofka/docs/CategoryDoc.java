package com.sofka.docs;

import co.com.sofka.domain.generic.Entity;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.SubCategory;

import java.util.HashSet;
import java.util.Set;

public class CategoryDoc extends Entity<CategoryId> {
    private CategoryName categoryName;
    private Set<SubCategory> subcategories;

    public CategoryDoc(CategoryId entityId, CategoryName categoryName) {
        super(entityId);
        this.categoryName = categoryName;
        this.subcategories = new HashSet<>();
    }

    public CategoryName categoryName() {
        return categoryName;
    }

    /**
     * Se agrega una subCategoria a el array de subcategorias
     * @param subCategory
     */
    public void addSubCategory(SubCategory subCategory) {
        if(subcategories.contains(subCategory)){
            throw new IllegalArgumentException("Esta sub categoria ya existe");
        }
        this.subcategories.add(subCategory);

    }
    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public Set<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }
}
