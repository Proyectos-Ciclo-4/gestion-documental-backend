package com.sofka.docs.values;

import co.com.sofka.domain.generic.Identity;

public class UserId extends Identity {
    private UserId(String uuid){
        super(uuid);
    }

    public UserId(){

    }

    public static UserId of(String uuid) {return new UserId(uuid);}
}
