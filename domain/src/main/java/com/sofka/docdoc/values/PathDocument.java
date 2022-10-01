package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.ValueObject;

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
