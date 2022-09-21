package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class CreatedDate implements ValueObject<LocalDate> {

    private final LocalDate createDate;
    public CreatedDate(LocalDate createDate){
        this.createDate = createDate;
    }

    @Override
    public LocalDate value() {
        return createDate;
    }
}
