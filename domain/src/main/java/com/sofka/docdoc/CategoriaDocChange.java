package com.sofka.docdoc;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docdoc.events.CategoryCreated;
import com.sofka.docdoc.events.SubCategoryCreated;

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
