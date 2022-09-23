package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.events.SubCategoryCreated;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.SubCategory;

import java.util.HashSet;

public class CategoriaDocChange extends EventChange {

    public CategoriaDocChange(CategoryDoc categoryDoc) {
        apply((CategoryCreated event) -> {
            categoryDoc.userId = event.getUserId();
            categoryDoc.categoryName = event.getCategoryName();
        });
        apply((SubCategoryCreated event) -> {
            categoryDoc.subCategory=new HashSet<>();
            categoryDoc.subCategory.add(event.getSubcategories());
        });
    }
}
