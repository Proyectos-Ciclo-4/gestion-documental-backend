package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

public class SubCategory implements ValueObject<String> {
    private final String name;

    public SubCategory(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
