package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descriptiondoc implements ValueObject<String> {
    private final String description;

    public Descriptiondoc(String description) {
        this.description = description;
    }

    @Override
    public String value() {
        return description;
    }
}
