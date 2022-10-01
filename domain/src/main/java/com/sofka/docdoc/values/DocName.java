package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.ValueObject;

public class DocName implements ValueObject<String> {
    private final String name;

    public DocName(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
