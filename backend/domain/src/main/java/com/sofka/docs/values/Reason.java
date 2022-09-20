package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

import java.io.Serializable;

public class Reason implements ValueObject<String> {
    private final String reason;

    public Reason(String reason) {
        this.reason = reason;
    }

    @Override
    public String value() {
        return reason;
    }
}
