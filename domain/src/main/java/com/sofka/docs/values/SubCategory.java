package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Set;

public class SubCategory implements ValueObject<String> {

    private String subCategory;

    public SubCategory() {
    }

    public SubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String value() {
        return subCategory;
    }
}
