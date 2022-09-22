package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.SubCategory;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.SubcategoryId;
import com.sofka.docs.values.SubcategoryName;

public class SubCategoryCreated extends DomainEvent {
    private CategoryId categoryId;
   //private String subcategoryId;
    private SubcategoryId subCategoryId;
    private SubcategoryName subcategoryName;



    public SubCategoryCreated(CategoryId categoryId,SubcategoryId subcategoryId, SubcategoryName subcategoryName){
        super("sofka.docs.subcategorycreated");
        this.categoryId = categoryId;
        this.subCategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public SubcategoryId getSubCategoryId() {
        return subCategoryId;
    }

    public SubcategoryName getSubcategoryName() {
        return subcategoryName;
    }
}
