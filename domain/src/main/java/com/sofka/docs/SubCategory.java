package com.sofka.docs;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Set;

public class SubCategory implements ValueObject<Set<String>> {

    private Set<String> subCategory;

    public SubCategory() {
    }

    public SubCategory(Set<String> subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public Set<String> value() {
        return subCategory;
    }
}
