package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

public class Responsible implements ValueObject<String> {
    private final String responsible;

    public Responsible(String responsible) {
        this.responsible = responsible;
    }

    @Override
    public String value() {
        return responsible;
    }
}
