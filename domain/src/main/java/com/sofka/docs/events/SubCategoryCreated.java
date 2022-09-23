package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.SubCategory;
import com.sofka.docs.values.SubcategoryId;
import com.sofka.docs.values.SubcategoryName;

import java.util.Set;

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
