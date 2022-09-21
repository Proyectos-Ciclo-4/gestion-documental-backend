package com.sofka.docs.values;

import co.com.sofka.domain.generic.ValueObject;

public class VersionDocument implements ValueObject<Integer> {

    private final Integer version;

    public VersionDocument(Integer version){
        this.version = version;
    }

    @Override
    public Integer value(){
        return value();
    }
}
