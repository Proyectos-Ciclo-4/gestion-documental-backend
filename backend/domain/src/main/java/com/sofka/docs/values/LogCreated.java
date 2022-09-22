package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class LogCreated implements ValueObject<LocalDate> {
    private final LocalDate createdDate;

    public LogCreated(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public LocalDate value() {
        return createdDate;
    }
}
