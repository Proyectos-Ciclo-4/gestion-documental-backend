package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.ValueObject;

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
