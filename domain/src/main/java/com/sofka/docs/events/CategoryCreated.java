package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.UserId;

public class CategoryCreated extends DomainEvent {
    private CategoryId categoryId;
    private CategoryName categoryName;
    private UserId userId;

    public CategoryCreated() {
        super("sofka.docs.categorycreated");
    }

    public CategoryCreated(UserId userId, CategoryId categoryId, CategoryName categoryName) {
        super("sofka.docs.categorycreated");
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public UserId getUserId() {
        return userId;
    }

    public CategoryId getId() {
        return categoryId;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

}
