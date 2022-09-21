package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.SubCategory;

public class SubCategoryCreated extends DomainEvent {
    private String categoryId;
   //private String subcategoryId;
    private SubCategory subCategory;

    public SubCategoryCreated(){
        super("sofka.docs.subcategorycreated");
    }

    public SubCategoryCreated(String categoryId,SubCategory subcategory){
        super("sofka.docs.subcategorycreated");
        this.categoryId = categoryId;
        //this.subcategoryId = subcategoryId;
        this.subCategory = subcategory;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public SubCategory getSubCategory(){
        return subCategory;
    }

}
