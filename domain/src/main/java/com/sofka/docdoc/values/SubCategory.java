package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.ValueObject;

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
