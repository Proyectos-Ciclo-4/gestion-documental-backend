package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Entity;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.UserId;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class CategoryDoc extends AggregateEvent<CategoryId> {
    protected CategoryName categoryName;
    protected Instant dateCreated;

    protected UserId userId;
    protected Set<SubCategory> subCategory;

    public CategoryDoc(UserId userId, CategoryId categoryId, CategoryName categoryName) {
        super(categoryId);
        this.categoryName = categoryName;
        this.dateCreated = Instant.now();
        this.subCategory = new HashSet<>();
        subscribe(new CategoriaDocChange(this));
        appendChange(new CategoryCreated(userId, categoryId, categoryName)).apply();
    }

    public CategoryDoc(CategoryId entityId) {
        super(entityId);
        subscribe(new CategoriaDocChange(this));
    }

}
