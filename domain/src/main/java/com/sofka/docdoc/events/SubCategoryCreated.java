package com.sofka.docdoc.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.values.SubCategory;

public class SubCategoryCreated extends DomainEvent {
    //private CategoryId categoryId;
    private SubCategory subcategories;




    public SubCategoryCreated(SubCategory subcategory){
        super("sofka.docs.subcategorycreated");
        this.subcategories=subcategory;
    }

    public SubCategory getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        return "SubCategoryCreated{" +
                ", subcategories=" + subcategories +
                '}';
    }
}
