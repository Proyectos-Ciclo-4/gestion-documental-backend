package com.sofka.docdoc;

import co.com.sofka.domain.generic.ValueObject;

public class NumberDownloads implements ValueObject {

    private Integer numberDownloads;

    public NumberDownloads(Integer numberDownloads) {
        this.numberDownloads = numberDownloads;
    }

    @Override
    public Integer value() {
        return numberDownloads;
    }

}
