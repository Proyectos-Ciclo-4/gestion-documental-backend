package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.Identity;

public class SubcategoryId extends Identity {
    public SubcategoryId(String uuid) {
        super(uuid);
    }

    public SubcategoryId() {
    }
    public static SubcategoryId of(String uuid) {return new SubcategoryId(uuid);}

}
