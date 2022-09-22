package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

public class SubcategoryName implements ValueObject<String> {
    private final String name;

    public SubcategoryName(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
