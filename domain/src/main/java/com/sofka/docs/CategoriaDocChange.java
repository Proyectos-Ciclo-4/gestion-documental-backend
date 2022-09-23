package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;

public class CategoriaDocChange extends EventChange {

    public CategoriaDocChange(CategoryDoc categoryDoc) {
        apply((CategoryCreated event) -> {
            categoryDoc.userId = event.getUserId();
            categoryDoc.categoryName = event.getCategoryName();
        });
    }
}
