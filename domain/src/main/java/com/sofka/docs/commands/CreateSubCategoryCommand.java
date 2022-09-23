package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

public class CreateSubCategoryCommand extends Command {
    private String categoryId;
    private String subCategoryName;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}
