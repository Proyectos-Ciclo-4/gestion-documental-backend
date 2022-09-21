package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class PathDocument implements ValueObject<String> {

    private final String pathDocument;
    public PathDocument(String  pathDocument){
        this.pathDocument = pathDocument;
    }

    @Override
    public String value() {
        return pathDocument;
    }
}
