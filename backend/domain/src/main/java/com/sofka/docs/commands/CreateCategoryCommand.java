package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

import java.util.Set;

public class CreateCategoryCommand extends Command {
    private String categoryId;
    private String categoryName;

    private Set<String> subcategories;

    public CreateCategoryCommand(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<String> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<String> subcategories) {
        this.subcategories = subcategories;
    }
}
