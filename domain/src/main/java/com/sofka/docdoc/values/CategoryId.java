package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.Identity;

public class CategoryId extends Identity {

    public CategoryId(String uuid){
        super(uuid);
    }

    public CategoryId(){

    }

    public static CategoryId of(String uuid) {return new CategoryId(uuid);}

}
