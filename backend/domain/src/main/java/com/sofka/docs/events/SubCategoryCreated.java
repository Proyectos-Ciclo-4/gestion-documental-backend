package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

public class SubCategoryCreated extends DomainEvent {
    private String categoryId;
   //private String subcategoryId;
    private String subCategoryName;

    public SubCategoryCreated(){
        super("sofka.docs.subcategorycreated");
    }

    public SubCategoryCreated(String categoryId,String subcategoryName){
        super("sofka.docs.subcategorycreated");
        this.categoryId = categoryId;
        //this.subcategoryId = subcategoryId;
        this.subCategoryName = subcategoryName;
    }

    public String getSubCategoryName(){
        return subCategoryName;
    }

}
