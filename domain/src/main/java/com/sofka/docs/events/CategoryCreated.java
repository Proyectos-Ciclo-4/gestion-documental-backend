package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;

public class CategoryCreated extends DomainEvent {
    private CategoryId id;
    private CategoryName categoryName;

    public CategoryCreated(){
        super("sofka.docs.categorycreated");
    }

    public CategoryCreated(CategoryId id,CategoryName categoryName){
        super("sofka.docs.categorycreated");
        this.id = id;
        this.categoryName = categoryName;
    }


    public CategoryId getId() {
        return id;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }
}
