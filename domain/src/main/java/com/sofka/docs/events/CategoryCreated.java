package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

public class CategoryCreated extends DomainEvent {
    private String id;
    private String categoryName;

    public CategoryCreated(){
        super("sofka.docs.categorycreated");
    }

    public CategoryCreated(String id,String categoryName){
        super("sofka.docs.categorycreated");
        this.id = id;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public String getCategoryName(){
        return categoryName;
    }

}
