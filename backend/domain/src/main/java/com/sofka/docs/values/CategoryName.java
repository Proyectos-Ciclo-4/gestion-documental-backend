package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

public class CategoryName implements ValueObject<String> {
    private final String name;

    public CategoryName(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
