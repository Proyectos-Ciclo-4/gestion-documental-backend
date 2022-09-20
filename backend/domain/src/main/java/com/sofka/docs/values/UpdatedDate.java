package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class UpdatedDate implements ValueObject<LocalDate> {

    private final LocalDate updatedDate;
    public UpdatedDate(LocalDate updatedDate){
        this.updatedDate = updatedDate;
    }

    @Override
    public LocalDate value() {
        return updatedDate;
    }

}
